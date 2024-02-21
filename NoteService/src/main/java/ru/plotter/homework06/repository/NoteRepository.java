package ru.plotter.homework06.repository;

import ru.plotter.homework06.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}