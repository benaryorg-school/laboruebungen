def isGueltig(s):
	return (s>=1.0 and s<=20.0)

class Rectangle(object):

	def __init__(self,length=1.0,width=1.0):
		self.setLength(length)
		self.setWidth(width)

	def __str__(self):
		return ';'.join([str(self.length),str(self.width)])

	def __repr__(self):
		return str(self)

	def setLength(self,length):
		length=float(length)
		if isGueltig(length):
			self.length=length
		else:
			raise ValueError('only [1.0;20.0]')

	def setWidth(self,width):
		width=float(width)
		if isGueltig(width):
			self.width=width
		else:
			raise ValueError('only [1.0;20.0]')

	def getUmfang(self):
		return (self.length+self.width)*2
	
	def getFlaeche(self):
		return self.length*self.width

if __name__=='__main__':
	rec=Rectangle()
	rec.setWidth("4")
	rec.setLength(5.0)
	print rec
	print 'Umfang: '+str(rec.getUmfang())
	print 'Flaeche: '+str(rec.getFlaeche())

