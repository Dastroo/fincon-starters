package eu.fincon.starterapp.operationhistory.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OperationHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
  @SequenceGenerator(name = "id_generator", sequenceName = "hibernate_sequence", allocationSize = 1)
  private Long id;

  @Version
  @Column(name = "versionid")
  private Long versionId;

  private LocalDateTime createDate;

  @Column(nullable = false)
  private String operation;

  private String params;
}
