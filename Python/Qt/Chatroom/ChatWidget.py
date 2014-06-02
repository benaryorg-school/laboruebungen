#!/usr/bin/env python2.7

"""

Written by benaryorg (@benaryorg/binary@benary.org)

"""

from PyQt4.QtCore import *
from PyQt4.QtGui import *

class ChatWidget(QWidget):

    def __init__(self,args,**kwargs):
        super(ChatWidget,self).__init__()
        self.args=args
        if self.args.verbose:
            print 'ChatWidget: __init__'
        self.initUi()
        if self.args.verbose:
            print 'ChatWidget: finished'

    def initUi(self):
        if self.args.verbose:
            print 'ChatWidget: initUi'

        layout=QGridLayout()

        self.text=QTextBrowser()
        layout.addWidget(self.text,0,0,1,5)

        self.edit=QLineEdit()
        self.connect(self.edit,SIGNAL('returnPressed()'),self.send)
        layout.addWidget(self.edit,1,0,1,4)

        self.button=QPushButton('Send')
        self.connect(self.button,SIGNAL('clicked()'),self.send)
        layout.addWidget(self.button,1,4,1,1)

        self.setLayout(layout)

    def send(self,*largs):
        self.text.append(self.edit.text())
        self.edit.setText('')

    def retranslateUi(self):
        if self.args.verbose:
            print 'ChatWidget: retranslateUi'
