using System;
using static System.Console;
using System.Collections.Generics;


namespace Pack.Shared;
{
    public class Person : object
    {
        //all fields 
        public string Name;
        public DateTime DateOfBirth;
        public List<Person> Children = new List<Person>();
        public const  string Species = "Homo Sapien"; // constants
        public readonly string HomePlanet = "Earth";  //read-only field
        public readonly DateTime Instantiated;

        //constructors 
        public Person()
        {
            //set default values for fields only 
            //including read-only fields 
            Name = "Unknown";
            Instantiated = DateTime.Now;
        }
        //mutiple constructors 
        public Person(string initialName, string homePlanet)
        {
            Name = initialName;
            HomePlanet = homePlanet;
            InstantiaTED = DateTime.Now;

        }
        
        //methods 
        public void WriteLineToConsole()
        {
            WriteLine($"{Name} was born on a {DateOfBirth:dddd}.");

        }
        public string GetOrigin()
        {
            return$"{Name} was born on {HomePlanet}"
        }

        public (string, int ) GetFruit()
        {
            return("Apples", 5);
        }

    }
}
