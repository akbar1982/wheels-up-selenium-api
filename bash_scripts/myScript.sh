mkdir myFiles      # Creating a new directory
cd myFiles         # Going inside directory

counter=1          # while loop conditions
total=7            # total value of files to be created

#the while loop creates the files
while [ $counter -le $total ]
do
    fileName="file$counter.txt"  
    touch $fileName
    echo $fileName
    ((counter++))
done

# deleting all the files except last 3 files 
ls -t1 ./ | tail -n +4 | xargs rm -r

# Putting all the files into array
files=(*)
total=5

# writing to the all files desired values with for loop
for name in ${files[@]}; do
if test -f "$name"; then
   echo "I'm file $total " > $name       # writing to the file 
   echo "I'm file $total "               # printing to console
   ((total++))
fi
done

echo All Done      