package com.rodrigues.wagner.demorx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Exemplo 1
//        val clubesObservable = Observable.just("Palmeiras","Sao Paulo",
//                "Corinthias", "Santos")
//
//        clubesObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .filter{ it.toUpperCase().startsWith("P") }
//                .subscribe(getClubesObserver())
//Exemplo 2
        Observable.range(1,20)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .filter {it % 2 == 0 }
                .map { "$it é par" }
                .subscribe(object : Observer<String> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: String) {
                        Log.i("TAG",t)
                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }

//    private fun getClubesObserver(): Observer<String> {
//        return object : Observer<String> {
//            override fun onSubscribe(d: Disposable) {
//                Log.d("TAG", "onSubscribe")
//            }
//
//            override fun onNext(clube: String) {
//                // tvClubes.text = "${tvClubes.text}\n$clube"
//                Log.d("TAG", "Nome: $clube")
//            }
//
//            override fun onError(e: Throwable) {
//                Log.e("TAG", "Erro: " + e.message)
//            }
//
//            override fun onComplete() {
//                Log.d("TAG", "Todos os itens emitidos")
//            }
//        }
//    }


}
