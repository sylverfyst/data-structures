# Ruby does data structures pretty well, arrays handle linked lists, queues, and stacks with built in methods, it's up to the
# programmer to stick to the behavior of those data structures.  Yes, I know a built in Hash class exists for Ruby, but I wanted
# as an exercise to build my own version to get a feel for the language and practice some data structures.   
module Hash_struct
	# Initialize the new Hash 
	def Hash_struct.new(num_containers = 256)
		aHash= []
		
		#for each index in num_containers, push an array into the array i.e. making a container for the key value pair
		(0...num_containers).each do |i| 
			aHash.push([])
		end
		
		return aHash
	end
	
	# Hashing function, uses Ruby's hash function to convert a string to a number, then % to convert it to a more reasonable number
	def Hash_struct.hKey(aHash, key)
		return key.hash % aHash.length
	end
	
	# Given a key, find the container where it could be placed
	def Hash_struct.get_container(aHash, key)
		#grab the key index
		container_id = Hash_struct.hKey(aHash, key) 
		return aHash[container_id]
	end
	
	# Return the index, key, and value of a member of the hash, uses default value of nil
	def Hash_struct.get_member(aHash, key, default=nil)
		container = Hash_struct.get_container(aHash, key)
		
		# for each element of container (grabbed by index above), get the index, key, and value 
		container.each_with_index do |kv, i|
			k, v = kv
			if key == k
				return i, k, v
			end
		end
		# error base case, return -1 for the index, key, and nil to let us know the Hash doesn't contain that member
		return -1, key, default
	end
	
	# Gets the value in a container for the given key, or the default. 
	def Hash_struct.get(aHash, key, default=nil)
		i, k, v = Hash_struct.get_member(aHash, key, default=default)
		return v
	end
	
	# set the key to the value, this method will replace duplicate keys.  
	def Hash_struct.set(aHash, key, value)
		# get the container that contains that key
		container = Hash_struct.get_container(aHash, key)
		# grab the index, key, and value for that container
		i, k, v = Hash_struct.get_member(aHash, key)
		
		# if the key exists, overwrite it.
		if i >= 0
			container[i] = [key, value]
		# otherwise add a new member to the container with key and value
		else
			container.push([key, value])
		end
	end	
	
	# deletes the given key from the Hash
	def Hash_struct.delete(aHash, key)
		container = Hash_struct.get_container(aHash, key)
		
		(0...container.length).each do |i|
			k, v = container[i]
			if key == k
				container.delete_at(i)
				break
			end
		end
	end
	
	# print what's in the Hash
	def Hash_struct.print_out(aHash)
		aHash.each do |container|
			if container
				container.each {|k, v| puts k, v}
			end
		end
	end
end
