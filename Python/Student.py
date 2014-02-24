from Person import Person

class Student(Person):
	def __init__(self,nn,vn,mn):
		Person.__init__(self,vn,nn)
		self.setMatrikelnummer(mn)

	def __str__(self):
		return ';'.join([Person.__str__(self),str(self.mn)])

	def setMatrikelnummer(self,mn):
		self.mn=int(mn)

if __name__=='__main__':
	s=Student('Huber','Karl',123456)
	print s
