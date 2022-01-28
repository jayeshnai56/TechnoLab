package com.lattitudetech.fragements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.google.gson.Gson
import com.lattitudetech.R
import com.lattitudetech.api.NetworkResult
import com.lattitudetech.databinding.FragmentUserFetchBinding
import com.lattitudetech.db.AppDatabase
import com.lattitudetech.db.AppDatabase.Companion.getAppDataBase
import com.lattitudetech.db.entity.DbUser
import com.lattitudetech.model.User
import com.lattitudetech.utils.Utils
import com.lattitudetech.viewModels.ViewModelUserFetch
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class UserFetchFragment : Fragment() {

    private lateinit var m: FragmentUserFetchBinding
    private var db: AppDatabase? = null


    private val vmUser by viewModels<ViewModelUserFetch>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        m = DataBindingUtil.inflate(inflater, R.layout.fragment_user_fetch, container, false)
        return m.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun fetchActiveUser() {

        m.pb.visibility = View.VISIBLE
        m.imgDone.visibility = View.GONE
        m.btnNext.visibility = View.GONE
        m.lblMessage.visibility = View.VISIBLE
        m.message = getString(R.string.fetching_users)

        if (Utils.isOnline(requireContext())) {
            vmUser.fetchUser()
            if (!vmUser.responseUser.hasObservers()) {
                vmUser.responseUser.observe(this, observerUser)
            }
        } else {
            m.pb.visibility = View.GONE
            m.imgDone.visibility = View.GONE
            m.btnNext.visibility = View.GONE
            m.lblMessage.visibility = View.VISIBLE
            m.message = getString(R.string.no_internet)
            Utils.showSnackBar(getString(R.string.no_internet), m.root)
        }
    }

    private fun init() {
        db = getAppDataBase(activity!!)



        fetchActiveUser()

        m.btnNext.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<UserListFragment>(R.id.container, args = null)
            }
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    // Observer
    ///////////////////////////////////////////////////////////////////////////

    private val observerUser: androidx.lifecycle.Observer<NetworkResult<List<User>>> =
        androidx.lifecycle.Observer { response ->
            if (activity != null && !activity!!.isDestroyed && !activity!!.isFinishing) {

                when (response) {
                    is NetworkResult.Success -> {
                        response.data?.let {
                            val list: MutableList<DbUser> = ArrayList()
                            response.data.indices.forEach { i ->
                                list.add(
                                    DbUser(
                                        response.data[i].id,
                                        response.data[i].name,
                                        response.data[i].username,
                                        response.data[i].email,
                                        Gson().toJson(response.data[i].address),
                                        response.data[i].phone,
                                        response.data[i].website,
                                        Gson().toJson(response.data[i].company)
                                    )
                                )
                                db!!.userDao().insert(list[i])
                            }
                            m.pb.visibility = View.GONE
                            m.imgDone.visibility = View.VISIBLE
                            m.btnNext.visibility = View.VISIBLE
                            m.lblMessage.visibility = View.VISIBLE
                            m.message = getString(R.string.user_data_saved)

                        }
                    }

                    is NetworkResult.Error -> {
                        m.pb.visibility = View.GONE
                        m.imgDone.visibility = View.GONE
                        m.btnNext.visibility = View.GONE
                        m.lblMessage.visibility = View.VISIBLE
                        m.message = getString(R.string.failed_to_load)
                        Utils.showSnackBar(getString(R.string.failed_to_load), m.root)
                    }

                    is NetworkResult.Loading -> {
                        m.pb.visibility = View.VISIBLE
                        m.imgDone.visibility = View.GONE
                        m.btnNext.visibility = View.GONE
                        m.lblMessage.visibility = View.VISIBLE
                        m.message = getString(R.string.fetching_users)

                    }
                }
            }
        }

}