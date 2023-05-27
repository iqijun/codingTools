package com.github.iqijun.codingtools.compents

import com.github.iqijun.codingtools.constants.Constants
import com.github.iqijun.codingtools.services.FormatJsonService
import com.intellij.ui.JBColor
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JSplitPane
import javax.swing.JSplitPane.HORIZONTAL_SPLIT
import javax.swing.JTextArea

class JsonFormatPanel(service: FormatJsonService)  : JPanel() {



    var leftPanel : JPanel = JPanel()

    var rightPanel : JPanel = JPanel()

    var leftJTextArea : JTextArea = JTextArea()

    var rightJTextArea : JTextArea = JTextArea()

    var formatBtton : JButton = JButton("格式化")
    var compressBtn : JButton = JButton("压缩")
    var copyBtn : JButton = JButton("复制")


    var jSplitPane : JSplitPane = JSplitPane(HORIZONTAL_SPLIT,leftPanel,rightPanel);



    init{
        preferredSize = java.awt.Dimension(Constants.CONTAINER_WITH, Constants.CONTAINER_HEIGHT)

        jSplitPane.dividerLocation = Constants.CONTAINER_WITH/2

        leftJTextArea.isEditable = true
        rightJTextArea.isEditable = true

        leftJTextArea.selectedTextColor = JBColor.DARK_GRAY
        rightJTextArea.selectedTextColor = JBColor.DARK_GRAY

        leftJTextArea.lineWrap = true
        rightJTextArea.lineWrap = true


        leftJTextArea.preferredSize = java.awt.Dimension(Constants.CONTAINER_WITH/2-20, Constants.CONTAINER_HEIGHT)
        rightJTextArea.preferredSize = java.awt.Dimension(Constants.CONTAINER_WITH/2-20, Constants.CONTAINER_HEIGHT)

        rightJTextArea.location = java.awt.Point(Constants.CONTAINER_WITH/2+10,0)
        leftPanel.add(leftJTextArea)
        rightPanel.add(rightJTextArea)

        jSplitPane.leftComponent = leftPanel
        jSplitPane.rightComponent = rightPanel
        layout= FlowLayout()
        formatBtton.addActionListener {
            rightJTextArea.text =  service.formatJson( leftJTextArea.text)
        }
        compressBtn.addActionListener {
            rightJTextArea.text =  service.compressJson( rightJTextArea.text)
        }
        copyBtn.addActionListener {
            service.copyResult(rightJTextArea.text)
        }
        add(formatBtton,"North")
        add(compressBtn,"North")
        add(copyBtn,"North")
        add(jSplitPane)
    }

}