CREATE TABLE tab_yard_slot (
    id BIGSERIAL PRIMARY KEY,
    block VARCHAR(2) NOT NULL,
    bay INT NOT NULL,
    slot INT NOT NULL,
    tier INT NOT NULL,
    max_weight_capacity DOUBLE PRECISION NOT NULL,
    is_operational BOOLEAN NOT NULL
);

CREATE TABLE tab_allocation (
    id BIGSERIAL PRIMARY KEY,
    container_id BIGSERIAL NOT NULL,
    yard_slot_id BIGSERIAL NOT NULL,
    arrival_date TIMESTAMP,
    estimated_departure TIMESTAMP,
    actual_departure TIMESTAMP,
    status VARCHAR(10) NOT NULL,
    CONSTRAINT fk_allocation_container FOREIGN KEY (container_id) REFERENCES tab_container(id),
    CONSTRAINT fk_allocation_yard_slot FOREIGN KEY (yard_slot_id) REFERENCES tab_yard_slot(id)
);