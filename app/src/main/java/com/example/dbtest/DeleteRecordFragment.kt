package com.example.dbtest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dbtest.Database.Student

import com.example.dbtest.R
import kotlinx.android.synthetic.main.fragment_delete_record.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class DeleteRecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete_record, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDelete.setOnClickListener(){
            try {
                val id: String = id_input.text.toString()
                val s = Student(id, "", "")

                val count = MainActivity.appDB.studentDAO().delete(s)

                if (count != 0) {
                    Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "ID not found", Toast.LENGTH_LONG).show()
                }
            }
            catch(e:Exception){
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
