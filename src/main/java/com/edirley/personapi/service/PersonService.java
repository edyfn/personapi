package com.edirley.personapi.service;

import com.edirley.personapi.dto.mapper.PersonMapper;
import com.edirley.personapi.dto.request.PersonDTO;
import com.edirley.personapi.dto.response.MessageResponseDTO;
import com.edirley.personapi.entities.Person;
import com.edirley.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

}

    //    private final PersonMapper personMapper;
//
//    public MessageResponseDTO create(PersonDTO personDTO) {
//        Person person = personMapper.toModel(personDTO);
//        Person savedPerson = personRepository.save(person);
//
//        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPerson.getId());
//
//        return messageResponse;
//    }
//
//    public PersonDTO findById(Long id) throws PersonNotFoundException {
//        Person person = personRepository.findById(id)
//                .orElseThrow(() -> new PersonNotFoundException(id));
//
//        return personMapper.toDTO(person);
//    }
//
//    public List<PersonDTO> listAll() {
//        List<Person> people = personRepository.findAll();
//        return people.stream()
//                .map(personMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
//        personRepository.findById(id)
//                .orElseThrow(() -> new PersonNotFoundException(id));
//
//        Person updatedPerson = personMapper.toModel(personDTO);
//        Person savedPerson = personRepository.save(updatedPerson);
//
//        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());
//
//        return messageResponse;
//    }
//
//    public void delete(Long id) throws PersonNotFoundException {
//        personRepository.findById(id)
//                .orElseThrow(() -> new PersonNotFoundException(id));
//
//        personRepository.deleteById(id);
//    }
//
//    private MessageResponseDTO createMessageResponse(String s, Long id2) {
//        return MessageResponseDTO.builder()
//                .message(s + id2)
//                .build();
//    }
//}
