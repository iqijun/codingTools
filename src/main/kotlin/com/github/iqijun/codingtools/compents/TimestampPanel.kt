package com.github.iqijun.codingtools.compents

import com.github.iqijun.codingtools.constants.Constants
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBList
import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JSplitPane
import javax.swing.JTextField

class TimestampPanel() : JPanel() {

    // 时间戳转时间
    val jTopPanel = JPanel()

    val timeStampLabel = JLabel("时间戳")

    val timeStampInput = JTextField(20)

    var timeStampBtn = JButton("转换")

    var dateTimeResult = JTextField(20)

    // 时间转时间戳
    val jBottomPanel = JPanel()



    var dateTimeInput = JTextField(20)

    var dateTimeToTimeStampBtn = JButton("转换")

    var timeStampResult = JTextField(20)

    val secondList = ComboBox<String>(arrayOf("秒","毫秒"))

    val jSplitPane = JSplitPane(JSplitPane.VERTICAL_SPLIT,jTopPanel,jBottomPanel)




    var dateTimeLabel = JLabel("时间")
    init {

        preferredSize = java.awt.Dimension(Constants.CONTAINER_WITH, Constants.CONTAINER_HEIGHT)
        border = javax.swing.BorderFactory.createTitledBorder("时间戳转换")

        jTopPanel.add(timeStampLabel)
        // timeStampInput 中的内容为当前时间戳
        timeStampInput.text = System.currentTimeMillis().toString()
        jTopPanel.add(timeStampInput)
        timeStampBtn.addActionListener {
            val timeStamp = timeStampInput.text
            if (timeStamp.length == 13) {
                val dateTime =
                    java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.util.Date(timeStamp.toLong()))
                dateTimeResult.text = dateTime
            } else if (timeStamp.length == 10) {
                val dateTime =
                    java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.util.Date(timeStamp.toLong() * 1000))
                dateTimeResult.text = dateTime
            }
        }
        jTopPanel.add(timeStampBtn)
        jTopPanel.add(dateTimeResult)
        // 以下是时间戳转时间的逻辑
        jBottomPanel.add(dateTimeLabel)
        jBottomPanel.add(dateTimeInput)
        // secondList 区分选中秒或者毫秒，为dateTimeToTimeStampBtn添加不同的处理方式
        dateTimeToTimeStampBtn.addActionListener {
            val dateTime = dateTimeInput.text
            if (secondList.selectedItem == "秒") {
                val timeStamp = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime).time / 1000
                timeStampResult.text = timeStamp.toString()
            } else if (secondList.selectedItem == "毫秒") {
                val timeStamp = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime).time
                timeStampResult.text = timeStamp.toString()
            }
        }
        jBottomPanel.add(dateTimeToTimeStampBtn)
        jBottomPanel.add(timeStampResult)
        jBottomPanel.add(secondList)


        // 不显示jSplitPane的分割线
        jSplitPane.dividerSize = 0
        add(jSplitPane)
    }


}