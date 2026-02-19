CREATE TABLE tab_container (
    id BIGSERIAL PRIMARY KEY,
    iso_code VARCHAR(11) NOT NULL,
    category VARCHAR(20) NOT NULL,
    size VARCHAR(20) NOT NULL,
    tare_weight DOUBLE PRECISION NOT NULL,
    payload_weight DOUBLE PRECISION NOT NULL,
    client_name VARCHAR(100) NOT NULL
);