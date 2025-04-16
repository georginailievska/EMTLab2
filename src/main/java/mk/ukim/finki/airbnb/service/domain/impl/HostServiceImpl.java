package mk.ukim.finki.airbnb.service.domain.impl;

import mk.ukim.finki.airbnb.model.domain.Host;
import mk.ukim.finki.airbnb.model.exceptions.HostNotFoundException;
import mk.ukim.finki.airbnb.repository.HostRepository;
import mk.ukim.finki.airbnb.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Host findById(Long id) {
        return hostRepository.findById(id)
                .orElseThrow(() -> new HostNotFoundException(id));
    }

    @Override
    public Host save(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Host update(Long id, Host updated) {
        Host existing = findById(id);
        existing.setName(updated.getName());
        existing.setSurname(updated.getSurname());
        existing.setCountry(updated.getCountry());
        return hostRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        hostRepository.deleteById(id);
    }
}
