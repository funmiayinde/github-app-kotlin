package com.voomsway.github_app.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.voomsway.github_app.data.model.GithubUser
import com.voomsway.github_app.data.repository.MainRepository
import com.voomsway.github_app.utils.Resource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by funmi ayinde on 16/03/2020.
 */
class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val users = MutableLiveData<Resource<List<GithubUser>>>();
    private val compositeDisposable = CompositeDisposable();

    fun fetchGithubUsers() {
        users.postValue(Resource.loading(null));
        compositeDisposable.add(
            mainRepository.getGithubUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    users.postValue(Resource.success(userList))
                }, { throwable ->
                    Log.e("error ==>>>", throwable.toString())
                    users.postValue(Resource.error("Something went wrong", null))
                })

        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear();
    }

    fun getGithubUsers(): LiveData<Resource<List<GithubUser>>> {
        return users;
    }
}