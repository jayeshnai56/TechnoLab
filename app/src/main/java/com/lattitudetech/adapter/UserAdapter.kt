package com.lattitudetech.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lattitudetech.R
import com.lattitudetech.TechnoLab
import com.lattitudetech.databinding.ItemUserBinding
import com.lattitudetech.interfaces.UserListInterface
import com.lattitudetech.model.User


class UserAdapter(private val data: List<User>, private val listener: UserListInterface) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewMainLayout = 0

    override fun getItemViewType(position: Int): Int {
        return viewMainLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VhUser(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(m: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == viewMainLayout) {

            val holder = m as VhUser

            val user = data[position]
            holder.binding.model = user

            if (data[position].name.startsWith("A")
                || data[position].name.startsWith("B")
                || data[position].name.startsWith("C")) {
                holder.binding.root.animation =
                    AnimationUtils.loadAnimation(holder.itemView.context, R.anim.translate)
            }

            holder.binding.lblExapand.setOnClickListener {
                holder.binding.lblExapand.text =
                    if (holder.binding.vMobile.visibility == View.GONE)
                        TechnoLab.context().getString(R.string.show_less)
                    else
                        TechnoLab.context().getString(R.string.show_more)
                holder.binding.vMobile.visibility =
                    if (holder.binding.vMobile.visibility == View.GONE) View.VISIBLE else View.GONE
                holder.binding.vCompany.visibility =
                    if (holder.binding.vCompany.visibility == View.GONE) View.VISIBLE else View.GONE
            }


            holder.binding.root.setOnLongClickListener {
                listener.onLongPress(position)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class VhUser(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)
}