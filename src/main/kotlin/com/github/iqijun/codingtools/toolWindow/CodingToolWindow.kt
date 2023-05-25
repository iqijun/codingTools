package com.github.iqijun.codingtools.toolWindow

import com.github.iqijun.codingtools.MyBundle
import com.github.iqijun.codingtools.compents.JsonFormatPanel
import com.github.iqijun.codingtools.compents.TimestampPanel
import com.github.iqijun.codingtools.constants.Constants.Companion.CONTAINER_HEIGHT
import com.github.iqijun.codingtools.constants.Constants.Companion.CONTAINER_WITH
import com.github.iqijun.codingtools.services.MyProjectService
import com.intellij.openapi.components.service
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTabbedPane

class CodingToolWindow(toolWindow: ToolWindow) {

    private val service = toolWindow.project.service<MyProjectService>()

    fun getContent() = JBPanel<JBPanel<*>>().apply {
//        val label = JBLabel(MyBundle.message("randomLabel", "?"))
//        add(label)
//        add(JButton(MyBundle.message("shuffle")).apply {
//            addActionListener {
//                label.text = MyBundle.message("randomLabel", service.getRandomNumber())
//            }
//        })


        val tabbedPane = JTabbedPane(JTabbedPane.LEFT)
        tabbedPane.preferredSize = java.awt.Dimension(CONTAINER_WITH, CONTAINER_HEIGHT)

        val jsonFormatPanel = JsonFormatPanel()
        val timestampPanel = TimestampPanel()

        tabbedPane.addTab("格式化json", jsonFormatPanel)
        tabbedPane.addTab("时间戳", timestampPanel)
        add(tabbedPane,"Center")

    }


}