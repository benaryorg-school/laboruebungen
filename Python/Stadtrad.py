from Fahrrad import Fahrrad

class Stadtrad(Fahrrad):
	def __init__(self,fahrer='',farbe='',v=0,richtung=0,licht=False):
		Fahrrad.__init__(self,fahrer,farbe,v,richtung)
		self.setLicht(licht)

	def __str__(self):
		return ';'.join([Fahrrad.__str__(self),'Licht: '+str(self.licht)])

	def setLicht(self,licht):
		licht=bool(licht)
		self.licht=licht

if __name__=='__main__':
	r=Stadtrad('Thomas','schwarz',licht=False)
	r.lenken(10)
	r.beschleunigen(0.3,9.8)
	r.setLicht(True)
	print r
