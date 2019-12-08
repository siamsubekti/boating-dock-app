# boating-dock-app

----------


**Project Title **

dock boat app

----------
**Installation**

if you are going to run this application program you can directly clone or download the zip file
in:
https://github.com/siamsubekti/boating-dock-app.git

then open it in your IDE such as: Intelij IDEA, eclipse, or other IDEs that support the maven project.

first, compile maven build to make a build jar :

    mvn clean install

Then, you can run the jar file in the terminal by :

    java -jar .\target\docking-lot-app-1.0-SNAPSHOT.jar file_inputs.txt

and if you only run without file_input.txt:
first your command line:

    $create_boating_dock 6
You can change a number other than 6

next command : 

    $dock KA-0112-ABJI Blue
and you can also change the ship's number and color

You can add as many ship dock numbers as you entered in the first command.

next commmand :

    $leave 1
if you have docked the ship, you can run the `$leave`  command with the list number that already exists.

next command :

    $registration_numbers_for_boats_with_colour Blue
enter the colors that have been registered, to search for registered ship numbers

next command : 

    $slot_numbers_for_boats_with_colour Blue
This is to look up the list of numbers.

next command :

    $slot_number_for_registration_number KA-0112-ABJI
to find a list of numbers by entering the ship number.


----------


**Contribute**

[Contribution guidelines for this project](docs/CONTRIBUTING.md)


----------
**License**

none of these licenses only share some source code


----------
