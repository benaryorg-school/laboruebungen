#!/usr/bin/env python2.7

"""

Written by benaryorg (@benaryorg/binary@benary.org)

"""

from PyQt4.QtCore import *
from PyQt4.QtGui import *

class NumberInput(QWidget):

    def __init__(self,args,**kwargs):
        super(NumberInput,self).__init__()
        self.args=args
        if self.args.verbose:
            print 'NumberInput: __init__'
        self.initUi()
        if self.args.verbose:
            print 'NumberInput: finished'

    def initUi(self):
        if self.args.verbose:
            print 'NumberInput: initUi'

        layout=QGridLayout()

        for i in xrange(10):
            button=QPushButton(str((i+1)%10))
            self.connect(button,SIGNAL('clicked()'),self.clicked)
            layout.addWidget(button,(i%10)/3,(i%10)%3)

        self.setLayout(layout)

    def clicked(self,*largs):
        if self.args.verbose:
            print 'NumberInput: send'

    def retranslateUi(self):
        if self.args.verbose:
            print 'NumberInput: retranslateUi'
