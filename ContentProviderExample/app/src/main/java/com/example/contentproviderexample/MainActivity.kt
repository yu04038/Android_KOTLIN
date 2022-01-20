package com.example.contentproviderexample

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.contentproviderexample.databinding.ActivityMainBinding
import org.jetbrains.annotations.Contract

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var cols = listOf<String>(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    ).toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root);

        // checkPermission()으로 앱이 퍼미션을 가지고 있는지 확인을 할 수 있다.
        // 다음과 같이 확인하고 싶은 퍼미션을 인자로 전달하면 PERMISSION_GRANTED 또는 PERMISSION_DENIED가 리턴된다.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted.
            // 퍼미션을 배열로 전달하는 이유는 이 API는 여러 퍼미션을 동시에 요청할 수 있도록 만들어졌기 때문이다. 한개의 퍼미션만 요청한다 하더라도 배열 이용.
            ActivityCompat.requestPermissions(this, Array(1){Manifest.permission.READ_CONTACTS}, 111)
        } else {

            // Permission is granted
            readContact()
        }
    }

    // Framework는 결과를 전달할 때 Activity의 onRequestPermissionResult()를 호출한다.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // grantResults 의 경우 여러 퍼미션을 요청할 수 있기 때문에 그 결과도 배열로 전달된다.
        // 여기서는 1개의 퍼미션을 요청하였기 때문에 index 0의 결과만 확인하면 된다.
        // 퍼미션을 받았다면 어떤 기능이 수행되도록 구현할 수가 있다.
        if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            readContact()
    }

    private fun readContact() {
        var from = listOf<String>(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone._ID).toTypedArray()

        var to = intArrayOf(android.R.id.text1, android.R.id.text2)

        // parameter : query(uri, projection, selection, selectionArgs, sortOrder)
        // uri : 원하는 데이터를 가져오기 위한 정해진 주소
        // projection : 가져올 컬럼 이름 목, null 이면 모든 컬럼
        // selection : where 절에 해당하는 내용
        // selectionArgs : selection 에서 ?로 표시한 곳에 들어갈 데이터
        // sortOrder : 정렬을 위한 order by 구문
        var rs = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                        cols, null, null,
                                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

        var adapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,
                                            rs, from, to, 0)

        binding.listView1.adapter = adapter
        binding.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{

            // 검색 버튼을 눌렀을 경우
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            // 텍스트가 바뀔때마다 호출
            override fun onQueryTextChange(p0: String?): Boolean {
                rs = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    cols, "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} Like ?",
                    Array(1){"%$p0%"},
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

                adapter.changeCursor(rs)
                return false
            }
        })
    }
}