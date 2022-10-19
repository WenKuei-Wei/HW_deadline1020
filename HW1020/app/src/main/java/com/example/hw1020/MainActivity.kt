package com.example.hw1020

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    /*@Override*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //連結XML元件
        var ed_name = findViewById<EditText>(R.id.gamer)
        //ed_name = findViewById(R.id.gamer);
        var tv_text = findViewById<TextView>(R.id.status)
        //tv_text = findViewById(R.id.status);
        var tv_name = findViewById<TextView>(R.id.name)
        var tv_winner = findViewById<TextView>(R.id.winner)
        var tv_mmora = findViewById<TextView>(R.id.our)
        var tv_cmora = findViewById<TextView>(R.id.their)
        var btn_scissor = findViewById<RadioButton>(R.id.Button1)
        var btn_stone = findViewById<RadioButton>(R.id.Button2)
        var btn_paper = findViewById<RadioButton>(R.id.Button3)
        var btn_mora = findViewById<Button>(R.id.play)
        //宣告、連結完成

        //按下PLAY按鈕
        btn_mora.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                //判斷字串是否空白:
                if (ed_name.length() < 1) tv_text.text = "趕快輸入名字啊 !!! "
                else {
                    tv_name.text = String.format("名字\n%s", ed_name.text.toString())
                    if (btn_scissor.isChecked)
                        tv_mmora.text ="我方出拳\n剪刀"
                    else if (btn_stone.isChecked)
                        tv_mmora.text ="我方出拳\n石頭"
                    else if (btn_paper.isChecked)
                        tv_mmora.text ="我方出拳\n布"
                }

                //Random 電腦出的拳:

                //Random 電腦出的拳:
                val com = (Math.random() * 3).toInt()
                if (com == 0)
                    tv_cmora.text = "電腦出拳\n剪刀"
                else if (com == 1)
                    tv_cmora.text ="電腦出拳\n石頭"
                else if (com == 2)
                    tv_cmora.text = "電腦出拳\n布"

                //判斷結果:
                if (btn_paper.isChecked && com == 1 || btn_stone.isChecked && com == 0 || btn_scissor.isChecked && com == 2) {
                    tv_winner.text = "勝利者\n${ed_name.text}".trimIndent()
                    tv_text.text = "你竟然贏電腦了!太強了吧"
                }
                else if (btn_paper.isChecked && com == 2 || btn_stone.isChecked && com == 1 || btn_scissor.isChecked && com == 0) {
                    tv_winner.text = "勝利者\n哈哈平手哈哈"
                    tv_text.text = "你跟電腦平手唷!"
                }
                else if (btn_paper.isChecked && com == 0 || btn_stone.isChecked && com == 2 || btn_scissor.isChecked && com == 1) {
                    tv_winner.text = "勝利者\n電腦贏囉哈哈"
                    tv_text.text = "笑死，你連電腦都輸!"
                }
            }
        }
        )
    }
}