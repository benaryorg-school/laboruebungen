class Auto(object):

	def __init__(self,name,motor=False):
		self.name=str(name)
		self.setMotor(motor)

	def __str__(self):
		if self.motor:
			return self.name+', Motor an'
		else:
			return self.name+', Motor aus'

	def __repr__(self):
		return str(self)

	def setMotor(self,motor):
		self.motor=bool(motor)

	def starten(self):
		self.motor=True

	def abstellen(self):
		self.motor=False

if __name__=='__main__':
	a1=Auto("BMW")
	a2=Auto("Porsche",True)
	
	print a1
	a1.starten()
	print a1
	print a2
	a2.abstellen()
	print a2
