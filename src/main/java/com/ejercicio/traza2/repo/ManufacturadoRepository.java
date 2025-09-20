package com.ejercicio.traza2.repo;

import com.ejercicio.traza2.model.Manufacturado;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class ManufacturadoRepository {
    private final Map<Long, Manufacturado> data = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public Manufacturado save(Manufacturado m) {
        if (m.getId() == null) m.setId(seq.incrementAndGet());
        data.put(m.getId(), m);
        return m;
    }

    public List<Manufacturado> findAll() { return new ArrayList<>(data.values()); }
    public Optional<Manufacturado> findById(Long id) { return Optional.ofNullable(data.get(id)); }
    public Optional<Manufacturado> update(Long id, Manufacturado nuevo) {
        if (!data.containsKey(id)) return Optional.empty();
        nuevo.setId(id);
        data.put(id, nuevo);
        return Optional.of(nuevo);
    }
    public Optional<Manufacturado> delete(Long id) { return Optional.ofNullable(data.remove(id)); }
}
