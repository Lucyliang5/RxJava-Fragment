package com.example.liangxiao.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

/**
 * Created by liangxiao on 2018/5/19.
 */
class EditFragment : Fragment() {
    companion object {
        const val TAG = "EditFragment"
    }

    var emitter: ObservableEmitter<String>? = null
    val observable: Observable<String> = Observable.create{
        emitter = it
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.edit_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val edit: EditText = view.findViewById(R.id.edit)
//        observable = Observable.create {
            edit.addTextChangedListener(object : TextWatcher{
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    emitter?.onNext(s.toString())
                }

            })
//        }

    }
}