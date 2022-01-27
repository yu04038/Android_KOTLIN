package com.example.viewmodelexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType {
    PLUS, MINUS
}
// 데이터의 변경
// 뷰모델은 데이터의 변경 사항을 알려주는 라이브 데이터를 가지고 있다.
class MyNumberViewModel : ViewModel() {

    companion object {
        const val TAG: String = "로그"
    }
    // 뮤터블 라이브 데이터 - 수정 가능한 녀석
    // 라이브 데이터 - 값 변동 안됨

    // 내부에서 설정하는 자료형은 뮤터블로 변경 가능하도록 설정
    private val _currentValue = MutableLiveData<Int>()

    // 변경되지 않는 데이터를 가지고 올 때 이름을 _언더스코어 없이 설정
    // 공개적으로 가져오는 변수는 private 이 아닌 퍼블릭으로 외부에서도 접근 가능하게 설정
    // 하지만 값을 직접 라이브데이터에 접근하지 않고 뷰모델을 통해 가져올 수 있도록 설정
    val currentValue: LiveData<Int>
        get() = _currentValue

    // 초기값 설정
    init {
        Log.d(TAG, "MyNumberViewModel - 생성자 호출")
        _currentValue.value = 0
    }

    // 뷰모델이 가지고 있는 값을 변경하는 메소드 
    fun updateValue(actionType: ActionType, input: Int) {
        when(actionType) {
            ActionType.PLUS ->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS ->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }
}