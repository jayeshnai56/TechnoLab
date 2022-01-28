package com.lattitudetech.fragements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.lattitudetech.R
import com.lattitudetech.adapter.UserAdapter
import com.lattitudetech.databinding.FragmentUserListBinding
import com.lattitudetech.db.AppDatabase
import com.lattitudetech.interfaces.ConfirmationInterface
import com.lattitudetech.interfaces.UserListInterface
import com.lattitudetech.model.User
import com.lattitudetech.utils.Utils
import java.util.*

class UserListFragment : Fragment(), ConfirmationInterface, UserListInterface {

    private lateinit var m: FragmentUserListBinding
    private var db: AppDatabase? = null
    private var listUser: MutableList<User> = ArrayList()
    private lateinit var adapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        m = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)
        return m.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        db = AppDatabase.getAppDataBase(activity!!)
        val list = db!!.userDao().getAll()

        for (i in list.indices) {
            listUser.add(
                i, User(
                    list[i].id,
                    list[i].name,
                    list[i].username,
                    list[i].email,
                    Gson().fromJson(list[i].address, User.Address::class.java),
                    list[i].phone,
                    list[i].website,
                    Gson().fromJson(list[i].company, User.Company::class.java)
                )
            )
        }
        adapter = UserAdapter(listUser, this)
        m.rv.adapter = adapter
    }


    ///////////////////////////////////////////////////////////////////////////
    // Interfaces
    ///////////////////////////////////////////////////////////////////////////

    override fun onConfirmationApproved(pos: Int) {
        listUser.removeAt(pos)
        adapter.notifyItemRemoved(pos)
        adapter.notifyItemRangeChanged(pos, listUser.size)
        if (listUser.size == 0)
            Utils.showSnackBar(getString(R.string.you_have_deleted_all_users), m.root)
    }

    override fun onLongPress(pos: Int) {
        val confirmationFragment = ConfirmationFragment(this, pos)
        confirmationFragment.show(
            requireActivity().supportFragmentManager,
            ConfirmationFragment::class.java.name
        )
    }


}