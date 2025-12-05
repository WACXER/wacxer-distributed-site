using System;
using static System.Console;

namespace Packt.Shared 
{
    public static Main(string args[]) {
            Person alice = new ()
            {
                Name = "Alice Jones",
                DateOfBirth = new(1998, 3, 7) //C* 9.0 or later
            } 
            WriteLine(format:"{0} was born on {1:dd MM yy}", 
            arg0: alice.Name,
            arg1: alice.DateOfBirth);

            Person bob = new Person()
            bob.Name = "Bob Smith";
            bob.DateOfBirth = new Datetime(1965, 12,  22 ); // C#$ 1.0 or later 

        WriteLine(format: "{0} was born on {1:dddd. d MMMM yyyy}", )
        
        
        public WondersOfTheAncientWorld FavoriteAncientWonder;
        bob.FavoriteAncientWonder = WondersOfTheAncientWorld.
        StatueOfZeusAtOlympia;

        bob.Children.Add(new Person {Name ="Alfred"});  // C# 3.0 and later 
        bob.Children.Add(new() {Name = "Zoe"}); // C# 9.0 and later 

        WriteLine(
            $"{nbob.Name} has {bob.Children.Count} children:"
        );

        for (int childIndex =  0; childIndex < bob.Children.Count; childIndex++)
        {
            WriteLine($"{bob.Children[childIndex]}");
        }

        BankAccount.InterestRate = 0.012M;  // store a shared value 

        BankAccount.jonesAccount = new();  //C# 9.0 or later 
        jonesAccount.AccountName = "Mrs. Jones";
        jonesAccount.Balance = 2400;

        WriteLine(format: "{0} earnmed {1:C } interest.", 
            arg0: jonesAccount.AccountName,
            arg1: jonesAccount.Balance * BankAccount.InterestRate);
        
        BAnkAccount gerrierAccount = new();
        gerrierAccount.AccountName = "Ms. Gerrier";
        gerrierAccount.Balance = 98;

        WriteLine(format: "{0} earned {1:C} interest ", 
             arg0: gerrierAccount.AccountName,
             arg1: gerrierAccount.Balance * BankAccount.InterestRate
             );

        WriteLine($"{bob.Name} is a {person.Species}");
        WriteLine($"{bob.Name} was born on {bob>HomePlanet}");

        Person blankPerson = new();
        WriteLine(format:
        "{0} of {1} was created at {2:hh:mm:ss} on {2:dddd}.",
        arg0: blankPerson.Name,
        arg1: blankPerson.HomePlanet,
        arg2: blankPerson.Instantiated
        );

        Person gunny = new(initialName: "Gunny", homePlanet: "Mars");
        WriteLine(format:
             "{0} of {1} was created at {2:hh:mm:ss} on a {2:dddd}.", 
             arg0: gunny.Name,
             arg1: gunny.HomePlanet,
             arg2: gunny.Instantiated
        );

        bob.WriteLineToConsole();
        WriteLine(bob.GetOrigin());

    }
    
}