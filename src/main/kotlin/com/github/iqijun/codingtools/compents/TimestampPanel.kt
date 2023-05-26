package com.github.iqijun.codingtools.compents

import com.github.iqijun.codingtools.constants.Constants
import com.intellij.openapi.wm.ToolWindow
import javax.swing.JPanel

class TimestampPanel() : JPanel() {


    init {
        preferredSize = java.awt.Dimension(Constants.CONTAINER_WITH, Constants.CONTAINER_HEIGHT)
    }

}