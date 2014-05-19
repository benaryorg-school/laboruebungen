from PyQt4.QtGui import *
import sys,random

class MainWindow(QDialog):

    def __init__(self):
        super(MainWindow,self).__init__()
        self.title='Main Window'
        self.initUi()

    def initUi(self):
        self.resize(400,300)
        layout=QGridLayout()
        self.textedit=QTextEdit()
        layout.addWidget(self.textedit)
        self.btn=QPushButton("test")
        self.btn.clicked.connect(self.foo)
        layout.addWidget(self.btn)
        self.setLayout(layout)
        self.retranslateUi()

    def foo(self,*largs):
        print self.textedit.toPlainText()
        self.close()

    def retranslateUi(self):
        self.setWindowTitle(self.title)

if __name__=='__main__':
    app=QApplication(sys.argv)
    win=MainWindow()
    win.show()
    sys.exit(app.exec_())
