from Person import Person

def search(lst,name):
	lst2=[]
	for s in lst:
		if name in s.name:
			lst2.append(s)
	return lst2

class Student(Person):
	def __init__(self,nn,vn,mn):
		Person.__init__(self,nn,vn)
		self.setMatrikelnummer(mn)

	def __str__(self):
		return ';'.join([Person.__str__(self),str(self.mn)])

	def setMatrikelnummer(self,mn):
		self.mn=int(mn)

if __name__=='__main__':
	s=Student('Huber','Karl',123456)
	print s
	s=[]
	vn=["Alfred", "Bernd", "Carola", "Dieter", "Erich",	"Gerda", "Hans", "Jochen", "Karin", "Maike"]
	nn=["Adler", "Baron", "Claus", "Dimov", "Eliot", "Gatti", "Heine","Jahn", "Kozak", "Miller"]
	mn=[12345, 45671, 23456, 11111, 45667, 98712, 23456, 65123, 12634, 22222]
	for i in xrange(len(vn)):
		s.append(Student(nn[i],vn[i],mn[i]))
	lst=search(s,'er')
	for s in lst:
		print s
