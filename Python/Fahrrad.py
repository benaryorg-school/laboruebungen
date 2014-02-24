class Fahrrad(object):
	def __init__(self,fahrer='',farbe='',richtung=0,v=0):
		self.fahrer=str(fahrer)
		self.farbe=str(farbe)
		self.setGeschwindigkeit(v)
		self.setRichtung(richtung)

	def __str__(self):
		return ';'.join(['Fahrer: '+self.fahrer,'Farbe: '+self.farbe,'Richtung: '+str(self.richtung),'km/h: %.2f'%self.getKmh()])

	def __repr__(self):
		return str(self)

	def setRichtung(self,richtung):
		richtung=float(richtung)
		if richtung>=-45 and richtung<=45:
			self.richtung=richtung

	def setGeschwindigkeit(self,v):
		v=float(v)
		self.v=v
		if self.v<0:
			self.v=0.0

	def lenken(self,grad):
		grad=float(grad)
		grad+=self.richtung
		if grad>45:
			self.grad=45.0
		elif grad<-45:
			self.grad=-45.0
		self.setRichtung(grad)

	def beschleunigen(self,a,sec):
		a=float(a)
		sec=float(sec)
		self.setGeschwindigkeit(self.v+(a*sec))

	def getKmh(self):
		return self.v*3.6

if __name__=='__main__':
	r=Fahrrad('Strampler','blau')
	r.lenken(10)
	r.beschleunigen(0.3,9.8)
	print r
