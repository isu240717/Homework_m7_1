package com.example.homework_m7_1.base

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.example.homework_m7_1.data.Resource
import com.example.homework_m7_1.utils.showToast

abstract class BaseFragment : Fragment() {

    fun <T> LiveData<Resource<T>>.stateHandler(
        success:(data:T) -> Unit,
        state: ((res:Resource<T>)->Unit) ?= null
    ){
        observe(this@BaseFragment){res->
            state?.invoke(res)
            when(res){
                is Resource.Error ->{
                    this@BaseFragment.showToast(res.message!!)
                    Log.e("ololo", "stateHandler: ${res.message}" )
                }
                is Resource.Loading ->{}
                is Resource.Success ->{
                    if (res.data != null){
                        success(res.data)
                    }
                }
                else ->{this@BaseFragment.showToast("else")}
            }
        }
    }

}