package accesModifier;

import finalPackage.FinalClass;

public class ClassB extends FinalClass{
	
	ClassA a = new ClassA();
	int b = a.a;

	FinalClass f = new FinalClass();
	int c = f.j;
}
