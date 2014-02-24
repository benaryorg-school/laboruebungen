class Ingredient(object):

	def __init__(self,name):
		self.setName(name)

	def __str__(self):
		return self.name

	def __repr__(self):
		return str(self)

	def setName(self,name):
		self.name=str(name)

	def power(self):
		return len(self.name)

if __name__=='__main__':
	ing=Ingredient('Spider')
	print ing
	print ing.power()
	ing.setName('Toad')
	print ing
	print ing.power()

