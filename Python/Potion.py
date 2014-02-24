from Ingredient import Ingredient

class Potion(object):

	def __init__(self,in1,in2,in3):
		self.stired=0
		self.ing=[in1,in2,in3]

	def __str__(self):
		lst=[]
		for ing in self.ing:
			lst.append(str(ing))
		lst.append(str(self.ready()))
		lst.append(str(self.power()))
		return ';'.join(lst)

	def __repr__(self):
		return str(self)

	def stir(self):
		self.stired+=1

	def ready(self):
		return (self.stired>=5)

	def power(self):
		pwr=0
		for ing in self.ing:
			pwr+=ing.power()
		if self.ready():
			pwr*=2
		return int(pwr)

if __name__=='__main__':
	in1=Ingredient('Toad')
	in2=Ingredient('Spider')
	in3=Ingredient('Lizard')
	p=Potion(in1,in2,in3)
	print p
	for i in xrange(5):
		p.stir()
	print p
