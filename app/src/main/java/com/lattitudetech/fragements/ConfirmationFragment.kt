package com.lattitudetech.fragements

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lattitudetech.R
import com.lattitudetech.databinding.FragmentConfirmationBinding
import com.lattitudetech.interfaces.ConfirmationInterface


class ConfirmationFragment(private  val cb :ConfirmationInterface, private val pos :Int) : BottomSheetDialogFragment() {

    private lateinit var m:FragmentConfirmationBinding

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        if (activity != null && !activity!!.isDestroyed && !activity!!.isFinishing) {
            val view =
                LayoutInflater.from(activity).inflate(R.layout.fragment_confirmation, null)
            m = DataBindingUtil.bind(view)!!
            dialog.setContentView(view)
            dialog.window!!.findViewById<View>(R.id.design_bottom_sheet)
                .setBackgroundResource(android.R.color.transparent)

            m.lblDismiss.setOnClickListener {
                dismiss()
            }
            m.lblYes.setOnClickListener {
                cb.onConfirmationApproved(pos)
                dismiss()
            }
        }
    }
}