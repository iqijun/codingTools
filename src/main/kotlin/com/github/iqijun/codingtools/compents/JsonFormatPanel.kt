package com.github.iqijun.codingtools.compents

import com.github.iqijun.codingtools.constants.Constants
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JSplitPane
import javax.swing.JSplitPane.HORIZONTAL_SPLIT
import javax.swing.JSplitPane.VERTICAL_SPLIT
import javax.swing.JTextArea

class JsonFormatPanel  : JPanel() {



    var leftPanel : JPanel = JPanel()

    var rightPanel : JPanel = JPanel()

    var leftJTextArea : JTextArea = JTextArea()

    var rightJTextArea : JTextArea = JTextArea()

    var formatBtton : JButton = JButton("格式化")


    var jSplitPane : JSplitPane = JSplitPane(HORIZONTAL_SPLIT,leftPanel,rightPanel);
    init{
        preferredSize = java.awt.Dimension(Constants.CONTAINER_WITH, Constants.CONTAINER_HEIGHT)

        jSplitPane.dividerLocation = Constants.CONTAINER_WITH/2

        leftJTextArea.isEditable = true
        rightJTextArea.isEditable = true

        leftJTextArea.preferredSize = java.awt.Dimension(Constants.CONTAINER_WITH/3, Constants.CONTAINER_HEIGHT/2)
        rightJTextArea.preferredSize = java.awt.Dimension(Constants.CONTAINER_WITH/3, Constants.CONTAINER_HEIGHT/2)

        leftPanel.add(leftJTextArea)
        rightPanel.add(rightJTextArea)

        jSplitPane.leftComponent = leftPanel
        jSplitPane.rightComponent = rightPanel
        layout= FlowLayout()
        add(formatBtton,"North")
        add(jSplitPane)
    }

}