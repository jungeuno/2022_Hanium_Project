package com.avengers.maskfitting.mafiafin.main.board.bulletinBoard

import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.AdapterView
import com.avengers.maskfitting.mafiafin.R
import com.avengers.maskfitting.mafiafin.databinding.FragmentBoardBinding
import com.avengers.maskfitting.mafiafin.main.QnABoard.QABoard

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private var mBinding: FragmentBoardBinding? = null
private val binding get() = mBinding!!
/**
 * A simple [Fragment] subclass.
 * Use the [Board.newInstance] factory method to
 * create an instance of this fragment.
 */
class Board : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        //버튼 클릭-> Q&A 게시판
        binding.board2.setOnClickListener {
          var intent = Intent(this, QABoard::class.java)
         startActivity(intent)
           }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // view 객체 생성
        val view = inflater.inflate(R.layout.fragment_board, container, false)

        // Adapter 생성
        val adapter: ListViewAdapter = ListViewAdapter()

        // 리스트뷰 참조 및 Adapter달기
        val listview: ListView = view.findViewById<View>(R.id.list) as ListView
        listview.adapter = adapter

        // 첫 번째 아이템 추가.
        adapter.addItem("user1", "테스트 입니다")
        // 두 번째 아이템 추가.
        adapter.addItem("user2", "테스트 입니다")
        // 세 번째 아이템 추가.
        adapter.addItem("user3", "테스트 입니다")


        // listview에 클릭 이벤트 핸들러 정의.
        listview.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            // get item
            val item = parent.getItemAtPosition(position) as ListViewItem

            val title = item.titleStr
            val content = item.contentStr
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment board.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Board().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}