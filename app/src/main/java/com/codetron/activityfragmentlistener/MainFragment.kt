package com.codetron.activityfragmentlistener

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainFragment : Fragment(R.layout.fragment_main), NotifyListener {

    private lateinit var textResult: TextView
    private lateinit var notifyListener: NotifyListener
    private val mainModel = MainModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        notifyListener = (context as NotifyListener)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textResult = view.findViewById(R.id.text_result)
        view.findViewById<Button>(R.id.button_add).setOnClickListener {
            notifyListener.notifyResult(mainModel.randomizeChar())
        }
    }

    override fun notifyResult(result: String) {
        textResult.text = result
    }
}