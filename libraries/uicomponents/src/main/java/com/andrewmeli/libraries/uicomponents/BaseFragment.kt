package com.andrewmeli.libraries.uicomponents

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment


open class BaseFragment : Fragment() {
    protected val TAG = this::class.qualifiedName

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAlertDialog()
    }


    private fun initAlertDialog() {
        val builder: AlertDialog.Builder =
            AlertDialog.Builder(requireContext(), R.style.CustomDialog)
        builder.setCancelable(false) // if you want user to wait for some process to finish,

        builder.setView(R.layout.layout_progress)
        dialog = builder.create()
    }

    fun showDialog() = dialog.show()
    fun dismissDialog() = dialog.dismiss()
}