CREATE TABLE `students` (
  `id`       INT           NOT NULL  AUTO_INCREMENT,
  `version`  INT           NOT NULL  DEFAULT 0,
  `email`    VARCHAR(255)  NOT NULL,
  `created`  TIMESTAMP     NOT NULL  DEFAULT NOW(),
  `modified` TIMESTAMP     NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));
