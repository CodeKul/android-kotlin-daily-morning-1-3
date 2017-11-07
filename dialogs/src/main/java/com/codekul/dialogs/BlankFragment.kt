package com.codekul.dialogs


import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.custom_dialog.view.*


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return when (tag) {
            "alert" -> alert()
            "date" -> dtPkr()
            "time" -> tmPkr()
            else -> custom()
        }
    }

    private fun alert(): Dialog {
        return AlertDialog.Builder(activity)
                .setTitle("Title")
                .setIcon(R.drawable.ic_launcher_background)
                .setMessage("Message")
                .setPositiveButton("yes", { dialogInterface, btn ->
                    dialogInterface.dismiss()
                })
                .show()
    }

    private fun dtPkr(): Dialog {
        return DatePickerDialog(
                activity,
                { _, year, month, date ->
                    Toast.makeText(activity, """ $date - ${month + 1} - $year """, Toast.LENGTH_SHORT).show()
                },
                2018,
                0,
                1
        )
    }

    private fun tmPkr(): Dialog {
        return TimePickerDialog(
                activity,
                { _, hh, mm ->
                    Toast.makeText(activity, """ $hh : $mm """, Toast.LENGTH_SHORT).show()
                },
                3, 8, true
        )
    }

    private fun custom(): Dialog {
        val vw = LayoutInflater.from(activity).inflate(R.layout.custom_dialog, null, false)
        val txt = vw.txtHdr
        return AlertDialog.Builder(activity).setView(vw).create()
    }
}
