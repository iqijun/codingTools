package com.github.iqijun.codingtools.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.diagnostic.thisLogger
import java.util.logging.Logger
import javax.swing.JOptionPane

class MyActions : AnAction() {
    private val LOG: Logger = Logger.getLogger(MyActions::class.java.name)

    override fun actionPerformed(e: AnActionEvent) {
        thisLogger().error("=======Hello World!==========")
        JOptionPane.showMessageDialog(null, "Hello World!");
    }


}