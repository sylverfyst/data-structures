require './hash-data-structure.rb'

# create a hash of state to abbreviation
states = Hash_struct.new()
Hash_struct.set(states, 'New Jersey', 'NJ')
Hash_struct.set(states, 'New York', 'NY')
Hash_struct.set(states, 'Massachussetts', 'MA')
Hash_struct.set(states, 'Rhode Island', 'RI')
Hash_struct.set(states, 'Vermont', 'VT')

# create a hash of state abbreviations to cities
cities = Hash_struct.new()
Hash_struct.set(cities, 'NY', 'Manhattan')
Hash_struct.set(cities, 'NJ', 'Trenton')
Hash_struct.set(cities, 'MA', 'Boston')

# add some more cities
Hash_struct.set(cities, 'VT', 'Montpelier')
Hash_struct.set(cities, 'RI', 'Providence')

# Output cities
puts '-' * 15
puts "NY has: #{Hash_struct.get(cities, 'NY')}"
puts "VT has: #{Hash_struct.get(cities, 'VT')}" 

# Output states
puts '-' * 15
puts "New York's abbreviation is: #{Hash_struct.get(states, 'New York')}"
puts "New Jersey's abbreviation is: #{Hash_struct.get(states, 'New Jersey')}"

# grab the city by first getting it the abbreviation from the states, and using that as a key
puts '-' * 15
puts "New York has: #{Hash_struct.get(cities, Hash_struct.get(states, 'New York'))}"
puts "New Jersey has: #{Hash_struct.get(cities, Hash_struct.get(states, 'New Jersey'))}"

# output all state abbreviations
puts '-' * 15
Hash_struct.print_out(states)

# output all cities
puts '-' * 15
Hash_struct.print_out(cities)

puts '-' * 15

# query for the city given the state full name or abbreviation, it doesn't like one character strings, will handle things not in the hash.  
while true
	puts "Give me a state: "
	print "> "
	state = $stdin.gets.chomp
	if state.length > 2
		grab = Hash_struct.get(states, state)
		break
	elsif state.length == 2
		grab = state
		break
	else
		puts "That doesn't seem like a state to me."
	end
end

if !grab
	puts "Sorry, no #{state}."
end

# checks if the city exists with || = operator, grab will default to nil if it wasn't found
# above.  If there's no city for that state in the 2nd hash, it will default to "Doesn't exist" and put out the value in city
city = Hash_struct.get(cities, grab, 'Doesn\'t exist')
puts "The city for the state '#{state}' is: #{city}"
