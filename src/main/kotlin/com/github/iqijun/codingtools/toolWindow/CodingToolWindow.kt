package com.github.iqijun.codingtools.toolWindow

import com.github.iqijun.codingtools.compents.JsonFormatPanel
import com.github.iqijun.codingtools.compents.TimestampPanel
import com.github.iqijun.codingtools.constants.Constants.Companion.CONTAINER_HEIGHT
import com.github.iqijun.codingtools.constants.Constants.Companion.CONTAINER_WITH
import com.github.iqijun.codingtools.services.FormatJsonService
import com.intellij.openapi.components.service
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.Panel
import javax.swing.JTabbedPane

class CodingToolWindow(toolWindow: ToolWindow) {

    private val formatJsonService = toolWindow.project.service<FormatJsonService>()

    fun getContent() = JBPanel<JBPanel<*>>().apply {
//        val label = JBLabel(MyBundle.message("randomLabel", "?"))
//        add(label)
//        add(JButton(MyBundle.message("shuffle")).apply {
//            addActionListener {
//                label.text = MyBundle.message("randomLabel", service.getRandomNumber())
//            }
//        })


        val tabbedPane = JTabbedPane(JTabbedPane.TOP)
        tabbedPane.preferredSize = java.awt.Dimension(CONTAINER_WITH, CONTAINER_HEIGHT)

        val jsonFormatPanel = JsonFormatPanel(formatJsonService)
        val timestampPanel = TimestampPanel()
        val rexPanel = Panel()
        val modPanel = Panel()

        tabbedPane.addTab("格式化json", jsonFormatPanel)
        tabbedPane.addTab("时间戳", timestampPanel)
        tabbedPane.addTab("正则表达式", rexPanel)
        tabbedPane.addTab("取模", modPanel)
        add(tabbedPane,"Center")

    }


}