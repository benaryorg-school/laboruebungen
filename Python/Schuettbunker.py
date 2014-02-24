class Schuettbunker(object):

	def __init__(self,anzsilos,maximum):
		if anzsilos<0 or maximum<0:
			raise ValueError('Value cannot be negative')
		self.maximum=int(maximum)
		self.anzsilos=int(anzsilos)
		self.kran=0
		self.silos={}
		for i in xrange(anzsilos):
			self.silos[i]=0

	def __str__(self):
		lst=[]
		for i in xrange(self.anzsilos):
			lst.append(str(self.silos[i]))
		lst.append(str(self.kran+1))
#		lst.append(str(self.anzsilos))
		return ';'.join(lst)

	def __repr__(self):
		return str(self)

	def fuell(self,anz):
		if int(anz)>=0:
			self.silos[self.kran]+=int(anz)
			if self.silos[self.kran]>self.maximum:
				self.silos[self.kran]=self.maximum
		else:
			raise ValueError('Negative or too high value!')

	def nachLinks(self,anz):
		self.kran-=int(anz)
		if self.kran<0:
			self.kran=0

	def nachRechts(self,anz):
		self.kran+=int(anz)
		if self.kran>=self.anzsilos:
			self.kran=self.anzsilos-1

	def gibAlles(self):
		tmp=self.silos[self.kran]
		self.silos[self.kran]=0
		return tmp

if __name__=='__main__':
	sb=Schuettbunker(5,10)
	sb.fuell(4)
	sb.fuell(1)
	sb.nachRechts(2)
	sb.fuell(20)
	sb.nachRechts(2)
	sb.fuell(1)
	sb.nachLinks(42)
	temp=sb.gibAlles()
	sb.nachRechts(1)
	sb.fuell(temp)
	print sb
