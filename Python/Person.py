from datetime import date

class Person(object):

	def __init__(self,name='N.N.',vorname='N.N.',geb=0):
		self.setGeb(geb)
		self.setZuname(name)
		self.setVorname(vorname)

	def __str__(self):
		return ' '.join([self.name,self.vorname])

	def __repr__(self):
		return str(self)

	def setGeb(self,geb):
		geb=int(geb)
		if geb>=1900:
			self.geb=geb
		else:
			self.geb=0

	def setZuname(self,name):
		self.name=str(name)

	def setVorname(self,vorname):
		self.vorname=str(vorname)

	def gleichAlt(p1,p2):
		if type(p1)==Person and type(p2)==Person:
			return p1.geb==p2.geb
		return False

	def getAlter(self):
		return date.today().year-self.geb

if __name__=='__main__':
	p=Person()
	p1=Person(geb=1978)
	p2=Person(name="Maier",geb=1967)
	p3=Person("Schmidt","Franz",1967)
	
	p1.setZuname("Bauer")
	p1.setVorname("Hans")
	p2.setVorname("Eva")
	
	print str(p1)+' ist '+str(p1.getAlter())+' Jahre alt!'
	if p2.gleichAlt(p3):
		print str(p2)+' und '+str(p3)+' sind gleich alt!'
	if Person.gleichAlt(p2,p3):
		print str(p2)+' und '+str(p3)+' sind gleich alt!'
