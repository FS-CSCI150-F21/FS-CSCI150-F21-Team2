#
# TABLE STRUCTURE FOR: user_information
#

DROP TABLE IF EXISTS `user_information`;

CREATE TABLE `user_information` (
  `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `salt` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('adah.cummings', 'mvke', 'e6c28d14e046d362027282c449facacc');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('adele32', 'zoip', '5507f86fc839c67164afad152319e89a');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('alek09', 'wkdj', 'e4e62b7819302889e5d7c8935a5d348c');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('alisha86', 'aqfm', '7e0176669ef1d6329e2d55cc8b2d5eb6');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('alysa.kilback', 'zkbv', 'aa0ad0d8821d3530626ec042f3c82587');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('annabelle82', 'swtc', '03d06a0168f9bc238041ee33c556e07d');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('antonetta61', 'tozq', '23824b8837851bb2929913072389228a');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ashleigh.stark', 'xprh', '25e0cb99f372d820d0f4d0aae12a1714');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ashly.gerlach', 'mbvd', 'd71a6cffac96a9f904eaa106ec3c8f9c');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('awiegand', 'zbwe', 'e58bcea8a251fd54eae3f6169e292e8e');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('batz.antone', 'tivc', '80238139cf801b3ff69bda55b8f5b2d8');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('celia47', 'yojj', '42d248bb13f13356863800b3d25e0be9');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('chirthe', 'zibn', '36807c64f2b9d3222d763c6ef9374567');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('darion56', 'tstc', '14718978ff70e59c9788899d7c630d6b');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('davin.murray', 'xfhh', '586ed87a1f23fab67b2261a0342a1592');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ddaniel', 'fomj', 'e45f68e99317680979a998c03a7722fc');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('dennis20', 'kxks', '07ed319978318492eb33730fac6fe181');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('easter21', 'gurx', '2ad75de9de2270a345b67b452061ce3c');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('elmo.langosh', 'ejzx', 'abc9c35c6721c0e80782c247a167e622');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('emmet.boehm', 'urej', '91431cb5747efc6d4f70589d7aeac43c');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('era.homenick', 'yzdw', '7857696a04c83eec7643b6550515740a');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ernesto82', 'grrc', '4395a764b82531ed700a0b7a3b836536');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ewald75', 'pnma', '6670d291ca8cf079bc67509a7754c302');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('felicity76', 'aqug', 'd242c92dd8764efd80aed97171c4e8bb');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('freida11', 'newl', 'f8900a89860a57fbc66e97c6ea139a14');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('gaston.wintheiser', 'hhuc', 'd074c4747b0e8ee05d384cca5f3762ee');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('gaston12', 'aqik', 'bb4ed9b68996543726fd5c3b1768ffa4');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('gerard04', 'weji', 'f8a2534a32e47461b5346ded01bc2c0b');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('glebsack', 'hcvo', '5e95ba853e8a5782c70a2b52ad3b7df8');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('glover.tod', 'cylz', 'a670be78baae0c4477858a1c0d46f5af');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('greichel', 'dwbv', '856a44f3bdb45ccb2545dcefbb4e140c');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('hbotsford', 'sjdx', 'd02699046e4df76c9c5dd9540cefde78');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('hessel.christop', 'qpap', 'b296ae033132d6e4fef3dfb0c649c6cb');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('hkoch', 'whdq', '7ce73e58f50f4316d1ad9bb71b01401d');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('htorphy', 'jory', '35fe6b96555ef7d5c3491677016c3672');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ikessler', 'etdn', '0d0436ea2ba9eba304eb3b7b87f844ca');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ikuhlman', 'vgld', 'b5c7879bcff3c55f2a25f0962e5deb1c');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('isabella.kessler', 'atlw', '455d2e39eba396825fec054e0b0be44b');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('jazlyn.bosco', 'wbwc', '9c50f981e3986b29daa82dd26784adf5');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('jenifer.moen', 'cxee', '0be4bafa402731b70052a5f9690f7a7c');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('jeramie09', 'egem', 'f4d3909e774f874b5c6a7c1ba5b38541');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('jesse.walker', 'fjgz', 'df4bac2c6fe0a1c69730dffcb70c8e10');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('joana.flatley', 'jowi', '01c62e6abda5dad150f4236f18208f4d');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('julien38', 'qixn', '4f6cea56a7c221642871052cef6f3946');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('kathryne71', 'ngbm', '3cf23d390d601042ebfd373043655f8f');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('kiehn.chris', 'tbyr', '658c80e88f549064b0dd61b7b14d0f9e');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('kortiz', 'hdly', 'd08a059123b39d6024c1da41b329f475');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('kub.jasen', 'exgi', 'a41058d5a9854cd38d9acc1aa3bc5341');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('kuhlman.adolfo', 'hfrt', '213f66cd5812331500eeadbf22c47ff0');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('kwisoky', 'genw', '09635bffcf71c646bffc5c25fbeca092');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('lacey95', 'dstl', 'a2e59aa94170cc0ead27f8b8904dfd73');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('lakin.brannon', 'xujj', 'c7c83bc8bbb3abcde8553c3d2d51778a');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('lsmith', 'anlq', '53e5a051cbf185d3c4328c2c128c8a87');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ltremblay', 'aqmh', 'e225757645977fe8e3da86d6dc7e6c95');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('lura67', 'vfpr', '22d416f4841fc215b32cee5d9f53336a');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('maritza.wisozk', 'cunk', 'd7b1a9a73db70f4474d3ed0e60656654');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('marks.luz', 'ulil', '85a686c71e1c0a090d480b2b9c10904d');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('maxine68', 'cmvm', '1f641aafa18387f77352365e68cc0c74');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('mbarton', 'qeim', '5cc9ff05ca7df793d249f4d3f257d9bb');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('mitchell.jameson', 'oyzd', '9cd0e5f1c03a7b8aa58de17d29b6dbf8');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('moen.melisa', 'kgnz', 'ac80c93d684673c68f90af33c9c23a9b');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('mohr.deborah', 'mibs', 'b48d97e057f765d221835439c043075f');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('mueller.shaun', 'qcps', 'c14bc25b7a720eedff12c5ce721ef327');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('nicole.wilkinson', 'qgkm', 'ab6ed87a396b423467537337d9cd6b45');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('nsenger', 'ootl', '92ed3d1f33ef5cf02df7707a938b0fab');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('nwisozk', 'wegp', '348c20e1cbe38c2907b7cd22de940b3c');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ondricka.august', 'vfja', '0d30374d999362fee7bd09a52ce3ab21');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ondricka.justen', 'rjox', 'bd320c3cc116ca42f1417c46cb37b90c');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ophelia74', 'zuse', '9a50552aba045703b2aa07b942b461d5');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('pearline.schmidt', 'npof', '357b8a35099dd024ca1c4769ef4c8cdf');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('pouros.edmond', 'lvhz', '2674fddb371e349137100b7ad92cfa71');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('prudence21', 'ejre', 'a670c8ef85a7d46916f425fdccaf17eb');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('qrowe', 'ywaq', 'de56b6bf93348d00322b873b4b2de68f');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('quinten30', 'pizl', '59a1cd286c8f6f02bbf59629ddcd887f');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('rhansen', 'nzst', 'e6482891080debfec204f12ca6fd7569');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ron.tillman', 'cfgs', 'dfa3049dee23415206a00796c843de73');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('rutherford.tara', 'ausf', '27694a28b2b50a6bccb0356ef7c6eb63');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('sandrine.schamberger', 'hnaq', '9d0f244680e6ce77cb56869a0315c154');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('sandy.goldner', 'nzsm', '2b9db4f945fdb7cb832f35efb1ab6daa');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('sedrick34', 'wkug', '4dbc40ddd6962aabb58df0b66e86218f');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('shaina.wisoky', 'omay', 'e501885ccf109b5e1357032d54c12761');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('shaun.rowe', 'rogo', '05339841aec14ba10af51a24f19a103e');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('sschmidt', 'gdti', '6ce234702c7bf4c12f9daad573092da5');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('stroman.eudora', 'bmnl', '08ec635a57a4b920d0957c51abb7c37e');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('sydnie37', 'qzad', '1ad0942f091e2eba0eec697e24d5204f');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('taryn.effertz', 'ujxk', '4c481bf3beac95610773124559fbc8c7');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('tfadel', 'vazj', '4aaed78264f35e5b1b5ddb6ac6f97a22');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('toy.bertram', 'ydog', '925106360174abca490cce8d0b745224');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ullrich.virginie', 'mpdk', 'b3ef265370bf8b4725d0f0f3a01f9a8d');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('uspinka', 'slru', 'c278f96ffee9e7057531bff4123cc4bc');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('vtowne', 'lvqx', '0ce0e6f60e57789f4262299917e45bb5');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('wehner.sage', 'vmco', 'ea674c17f69f3d6d94e1aab64a546bf3');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('will.erdman', 'xfeu', '629557e70285620b4a904bf34f82bc33');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('wjohns', 'fose', 'c8b3e44741fa2de60b3d6fa879b84919');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('wolf.mathilde', 'zlrd', '45580e64ca21bfabe41de66e631e8c9b');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('xolson', 'rtxz', 'e866a8c391a21039f4e4e06f197d3d14');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('xyost', 'vcyo', '0012ea64ee75c545b7eed40275404877');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('ycrooks', 'hgas', 'e5966f560bc9041e5a373a953dd686e8');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('zaria.heller', 'lqgc', '431e1abd755c780cf4b23bf4dedac044');
INSERT INTO `user_information` (`username`, `salt`, `password`) VALUES ('zquigley', 'jvvd', '5cdbad3ccd3add3bdc5278ff7f1dd618');

#
# TABLE STRUCTURE FOR: connection_information
#

DROP TABLE IF EXISTS `connection_information`;

CREATE TABLE `connection_information` (
  `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `garden_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `host` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `garden_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`garden_id`),
  KEY `username` (`username`),
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `user_information` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('jeramie09', '01cc5c7a-1d2c-3af4-b04e-36aee80efd3a', '32.182.145.3', 45, 'accusantium');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('glover.tod', '01f0b9c0-f6e7-3e1e-b231-0afbd1477a11', '246.193.113.129', 46, 'et');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('sedrick34', '0398ae6d-847d-3338-b1e7-9899b8e61775', '243.9.142.165', 16, 'reiciendis');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('alysa.kilback', '09924e3c-368a-3f5b-905f-eded3eb54d6e', '49.242.95.59', 28, 'adipisci');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('toy.bertram', '0bea9ce9-d61d-3e8d-908a-b664fb740640', '199.119.39.212', 24, 'error');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('zquigley', '13052a17-d854-358d-a03d-aa76ddcb3ef9', '221.160.57.215', 49, 'consequatur');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('darion56', '13e7e23e-b0aa-36c1-a98a-b15de9fad91e', '124.202.3.81', 37, 'quod');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ophelia74', '16161e0c-dc5a-3e9a-b827-bd8799b1f59c', '70.121.73.56', 93, 'ut');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('felicity76', '170b3e91-7eae-3e01-adb7-0399617f2eb0', '51.108.42.82', 55, 'saepe');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('kiehn.chris', '17ab745c-9b80-3a08-a87c-1e7578f6060d', '229.167.186.136', 67, 'tenetur');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('moen.melisa', '17b0b581-013f-3617-8f21-5deb33e5553d', '113.222.95.25', 32, 'quod');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('greichel', '18db64a1-fa31-358d-8be2-746a873ca7ae', '31.154.112.207', 73, 'velit');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('hkoch', '18fbd7e8-e5d7-3db6-abdc-8e18906a4d44', '254.172.19.240', 39, 'similique');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('mbarton', '1a2b85df-971b-3926-8af4-c7a45d190cf6', '140.60.91.16', 54, 'nihil');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('julien38', '1e48f3f6-4810-3223-bb57-5c96ee97eeb6', '99.72.89.226', 60, 'omnis');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('easter21', '23b8ebe9-9afe-31c4-97f0-6c079dc846a5', '19.241.114.176', 3, 'id');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('lura67', '2cd7214b-c810-3f3d-8fb6-650d7757ccba', '180.219.207.249', 39, 'non');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('rhansen', '2fc7e95c-fc02-3390-97c7-65124e88fff3', '118.92.58.22', 97, 'dolor');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('awiegand', '3164e7f0-de97-31d1-b99e-bdba9b318d76', '102.152.90.235', 39, 'aut');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('vtowne', '34a50d25-8c5b-33fd-92b2-27b94b48c514', '215.230.48.157', 49, 'ea');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('glebsack', '376ca22e-b9b1-378a-bd20-a00853148640', '62.0.159.52', 36, 'excepturi');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('mitchell.jameson', '385ea231-f392-3fef-9b28-173ebf88b731', '162.158.111.48', 89, 'tempora');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('tfadel', '3a69d23a-af7b-3ca4-a6a7-bc8eeffcb20b', '18.185.231.103', 26, 'eum');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('batz.antone', '3b8f0705-4fd0-316d-b910-48428f915560', '26.102.132.223', 10, 'et');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('gaston.wintheiser', '3ccbfe6d-b234-3e86-bab9-265dda0e2992', '238.230.109.48', 58, 'sequi');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('emmet.boehm', '4085a0bd-8da9-38fb-96c5-8dd99de6dc83', '201.220.98.25', 18, 'impedit');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ondricka.justen', '4202d2a2-a8fa-391c-9936-d07c599478b0', '25.36.28.54', 46, 'a');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ernesto82', '44c13a02-f73d-3703-9208-e7103daaa9e1', '156.209.19.119', 72, 'error');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('pearline.schmidt', '47fde477-1be2-3e6b-9af4-d5ddba0f215b', '117.153.187.1', 24, 'et');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('sandrine.schamberger', '4ae22870-d140-3ddc-a3db-7491b6743b2d', '85.102.57.179', 17, 'non');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('dennis20', '4e1d8909-63ec-3cd6-a72c-c29150cd02a0', '102.57.234.85', 58, 'vero');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('wolf.mathilde', '519f604f-2f3b-33f6-a36b-d42514ea98d8', '23.216.102.176', 7, 'aperiam');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ron.tillman', '5fbfe7f1-9ef5-3fee-9d24-440ea9fe8330', '78.92.157.132', 56, 'iste');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('kuhlman.adolfo', '61090d20-6c01-3180-8599-3589401f8e70', '0.156.70.35', 24, 'delectus');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('nicole.wilkinson', '63841471-969d-30f2-bf2e-afba0d87369d', '120.1.206.70', 80, 'id');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('uspinka', '68af4aa8-bc94-387e-acc8-2adbe358b8f0', '167.241.183.96', 65, 'quas');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ondricka.august', '6ad7748e-939b-3e49-a313-f0751c9f99d2', '233.252.181.239', 47, 'laborum');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('qrowe', '6d4b9987-99df-3ec6-9388-605e776a697e', '10.140.129.179', 66, 'itaque');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('elmo.langosh', '6fc0554e-bd0c-37cf-805e-62c48b854555', '40.72.9.222', 34, 'voluptatem');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('lacey95', '70b44690-2396-31d6-9211-cfe4c98bd50b', '160.212.122.25', 25, 'aut');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('wjohns', '727b1d4e-6e7e-3fa8-afd2-fded642691dc', '49.124.225.92', 92, 'nisi');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('nsenger', '72ed0c55-712a-3725-ba55-142f86a6003e', '19.249.172.215', 25, 'sed');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('will.erdman', '7360391c-ae9f-3cc5-935d-55f4eab6be2d', '174.12.16.234', 67, 'architecto');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('quinten30', '73d437f0-fb86-3e84-8d6f-6e7ccb10bd69', '201.42.146.123', 20, 'facilis');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('alek09', '77c4d8d3-88ee-3ae2-bbd1-e963348b41a8', '11.4.115.63', 58, 'voluptatibus');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('prudence21', '7b644dab-0817-38ee-ad38-7fb7397c50fb', '13.26.143.201', 37, 'molestiae');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('pouros.edmond', '7d5a3688-217e-3e81-ad8c-77475332ced6', '9.240.113.232', 9, 'distinctio');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('stroman.eudora', '7e13a39b-321d-36e2-b846-1f37bb621fee', '182.74.93.95', 40, 'sint');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ewald75', '7e52b998-52e9-3c47-86c3-a07261f5d305', '126.149.159.7', 76, 'modi');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('hbotsford', '82245be3-14ea-37d8-9f33-8928e5cd4c5d', '239.99.54.178', 68, 'porro');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('alisha86', '8257678e-16b7-36e4-8061-292a7b60dc66', '51.61.247.172', 67, 'eaque');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('nwisozk', '838a95bf-ab01-31fd-969a-7804a7ce3d27', '19.238.161.186', 1, 'expedita');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('kwisoky', '8a4a3a7c-96b0-331b-9cb9-0a582e01b6f4', '193.61.232.146', 39, 'totam');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('shaina.wisoky', '8bce3789-76e3-396f-a1fa-fe481daae895', '175.47.94.160', 57, 'vero');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('isabella.kessler', '8f48f420-bfd5-3500-81c3-c47f1b5081bf', '64.8.233.98', 11, 'quia');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ddaniel', '936017f9-12d4-3e56-8d60-bb8cc6612285', '22.16.107.15', 98, 'laborum');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('shaun.rowe', '947ee120-f501-3bf9-af94-0867d5df65ee', '122.83.245.176', 89, 'voluptates');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('celia47', '98222bff-b38d-3588-b8a2-de875d466e57', '12.24.11.147', 0, 'et');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('taryn.effertz', '985c7cad-2af5-361f-9e41-c2c8640d2d51', '198.43.108.9', 93, 'deserunt');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('xolson', 'a5345ff8-10ff-3fec-86d2-9964dba2e62b', '189.74.196.164', 31, 'non');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('annabelle82', 'a5b7dbcb-e906-312f-8922-fbdcfde1e7f4', '155.238.111.85', 79, 'aliquam');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('maxine68', 'a77230a9-0493-34cd-8714-18768d3cb6ca', '51.118.242.0', 56, 'vel');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('rutherford.tara', 'ac92dd68-d831-3c1f-92c4-a52319b1fa19', '177.211.116.84', 65, 'ut');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('kortiz', 'ae025fa4-df2c-3bd5-9da6-51d80c919bef', '226.0.179.109', 46, 'est');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('htorphy', 'b083a219-049b-3304-8862-8ab33fc19351', '96.125.140.207', 45, 'aut');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('hessel.christop', 'b1813d4e-d417-3edd-96a7-4f48874260cf', '129.18.64.85', 89, 'nisi');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('antonetta61', 'b1a5157f-69f5-3e3f-a64a-f1bd754e09be', '160.100.119.63', 73, 'nisi');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('marks.luz', 'b2cd48b5-6dfd-3c6e-8278-9f480cddae61', '64.3.15.33', 46, 'voluptatem');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('sydnie37', 'b2f81522-b1e6-3445-ab38-c291a4749aac', '92.15.196.117', 75, 'iure');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('jenifer.moen', 'b797e504-0be1-3513-93e2-2c792c248f0d', '175.178.161.235', 13, 'nemo');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('kub.jasen', 'b85aede4-4d72-33d2-b5dc-8565f8faa9b7', '125.143.56.45', 92, 'accusantium');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('freida11', 'bb45ff14-39ca-313a-9821-fe22a30f0ab6', '218.255.84.15', 51, 'voluptas');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('mueller.shaun', 'c036c3b6-e3b3-3470-95f0-b8290e0aaeed', '210.215.72.221', 96, 'quia');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('gerard04', 'c27fc098-8f22-3852-a723-900b989d0428', '159.15.138.148', 58, 'perferendis');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ikessler', 'c2c612d8-a925-332b-87e0-96d30f4d2ca6', '136.19.145.106', 72, 'voluptatem');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('joana.flatley', 'c352bd4e-50dc-3a26-97a5-c1e974932470', '19.106.245.78', 89, 'minima');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('gaston12', 'c76ad293-8034-3241-8fbc-923e4d9235db', '169.124.19.104', 19, 'optio');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ltremblay', 'c944b1f7-a800-32af-b2fb-b12e37041ffd', '16.8.211.67', 52, 'placeat');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('mohr.deborah', 'ca1b8ab5-b86c-3cdc-8866-3aa7db127dcb', '223.172.27.91', 16, 'necessitatibus');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('chirthe', 'ca329ceb-b750-3693-9bf6-0929c9937abe', '13.26.135.176', 55, 'ut');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('adah.cummings', 'cb120020-3071-3ad1-8224-1f69e6b2877d', '41.2.253.172', 5, 'corporis');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('sschmidt', 'cb50c760-a605-36ba-81f6-c932d24dff24', '245.210.74.223', 31, 'laudantium');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ashleigh.stark', 'cb7b660d-2b3a-365a-8fc2-a174ba11ea96', '185.131.171.141', 5, 'voluptas');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('lsmith', 'cc0d7093-0ee4-39c2-93c4-48fd9221c035', '3.26.197.251', 4, 'a');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('maritza.wisozk', 'cdc4d4e8-9fc4-3fff-9698-979b7fed4960', '130.182.179.40', 95, 'dicta');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('wehner.sage', 'd1d12092-720b-3c0d-96ef-cace5658c86a', '50.44.239.153', 2, 'nostrum');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ullrich.virginie', 'db8445eb-1f17-3720-bea1-56bcee565192', '110.208.68.144', 86, 'aperiam');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ashly.gerlach', 'e5cd4480-d65b-3e4a-88a8-8e641c4dd6c7', '215.97.56.100', 19, 'asperiores');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('jesse.walker', 'e64a984c-9f44-3c57-ba8c-732076e210bb', '8.94.31.214', 67, 'quod');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('era.homenick', 'e6ea9036-3900-3840-b2c9-a4412e84b864', '207.69.131.226', 90, 'rerum');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('lakin.brannon', 'ebc557d8-f052-3bb9-bf61-2d5e4d01fc66', '218.43.89.103', 2, 'ut');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('kathryne71', 'ebf82ab9-9083-3cb2-9d25-3aae148b95e3', '248.198.191.85', 55, 'quibusdam');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('davin.murray', 'ed4d5058-2a9a-3a71-a3f3-3dea618d40f0', '15.234.135.36', 56, 'accusamus');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('sandy.goldner', 'f0a08c2d-ebec-3116-98d1-10f3a56848c3', '243.244.180.112', 72, 'exercitationem');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('zaria.heller', 'f39e62d4-bc1c-3460-af51-96e525b40e01', '222.163.255.75', 76, 'ipsam');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ikuhlman', 'f426ce3e-0439-3e94-a053-9592cc5be1e0', '96.121.16.47', 12, 'porro');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('adele32', 'f7ca4344-c314-3afa-8f93-b5c383073707', '237.215.64.117', 37, 'quia');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('xyost', 'f90e7d6d-cf66-3e52-948d-ecfb87161f89', '247.62.9.188', 3, 'consequuntur');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('ycrooks', 'f9e16019-928c-3ea3-b07f-141a114e260a', '215.1.103.41', 27, 'delectus');
INSERT INTO `connection_information` (`username`, `garden_id`, `host`, `port`, `garden_name`) VALUES ('jazlyn.bosco', 'fdc6cdf7-ff22-3d9b-b024-18f000364705', '24.152.225.13', 36, 'fugit');


#
# TABLE STRUCTURE FOR: garden_images
#

DROP TABLE IF EXISTS `garden_images`;

CREATE TABLE `garden_images` (
  `garden_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `image_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`garden_id`,`timestamp`),
  CONSTRAINT `garden_id_images` FOREIGN KEY (`garden_id`) REFERENCES `connection_information` (`garden_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('01cc5c7a-1d2c-3af4-b04e-36aee80efd3a', '1998-12-11 22:36:12', 'tmp//73ebf8538c89588784ddd71c79778881.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('01f0b9c0-f6e7-3e1e-b231-0afbd1477a11', '2006-02-06 17:20:01', 'tmp//ba9d491498176ad864c1b93e1e7c8bca.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('0398ae6d-847d-3338-b1e7-9899b8e61775', '2015-02-23 10:01:59', 'tmp//cfc9cfed2619d059e36555aaaeeeaa07.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('09924e3c-368a-3f5b-905f-eded3eb54d6e', '2009-04-06 18:04:15', 'tmp//df78a402e14a7a760794fb2b41796835.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('0bea9ce9-d61d-3e8d-908a-b664fb740640', '2001-12-16 05:11:58', 'tmp//23d58ba13f858d664688bedeadab98f7.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('13052a17-d854-358d-a03d-aa76ddcb3ef9', '2014-09-03 21:39:43', 'tmp//25a1f57547423772e3f0579f435ace42.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('13e7e23e-b0aa-36c1-a98a-b15de9fad91e', '2005-03-07 00:57:40', 'tmp//8916312754d4bc37521627fe31ab5f5e.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('16161e0c-dc5a-3e9a-b827-bd8799b1f59c', '2005-03-26 12:06:53', 'tmp//a095bdcbb754eee728cfffb47bc1a747.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('170b3e91-7eae-3e01-adb7-0399617f2eb0', '2019-03-27 18:58:12', 'tmp//f4d428a6aebeab54c46c1c0f8b9b4ec6.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('17ab745c-9b80-3a08-a87c-1e7578f6060d', '2016-01-24 10:54:14', 'tmp//f22909ef2114fd4f3afac4ebea24761f.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('17b0b581-013f-3617-8f21-5deb33e5553d', '2007-03-27 19:41:27', 'tmp//436edfb27ae8228ff7b4534fb48f6302.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('18db64a1-fa31-358d-8be2-746a873ca7ae', '2005-12-19 15:48:36', 'tmp//72d7bf673b423646a98806d66dc70c9a.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('18fbd7e8-e5d7-3db6-abdc-8e18906a4d44', '1997-04-25 14:44:30', 'tmp//aafa2ad9eced3a9065743a408a70a86a.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('1a2b85df-971b-3926-8af4-c7a45d190cf6', '1970-11-06 17:27:33', 'tmp//0d11903df760c3b45e9fb241ce00c632.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('1e48f3f6-4810-3223-bb57-5c96ee97eeb6', '1984-05-06 06:51:13', 'tmp//16f571b3e43acabf120bef1012e41aea.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('23b8ebe9-9afe-31c4-97f0-6c079dc846a5', '2016-06-15 03:34:06', 'tmp//d12bf71b36f4cb1e56da09ed9142246f.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('2cd7214b-c810-3f3d-8fb6-650d7757ccba', '1980-09-05 10:28:56', 'tmp//d06d418d752afd94fc1547cf6530ef28.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('2fc7e95c-fc02-3390-97c7-65124e88fff3', '2004-10-03 17:54:01', 'tmp//3ba66a2054bcba03c63bd3f203923603.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('3164e7f0-de97-31d1-b99e-bdba9b318d76', '2015-09-18 13:38:07', 'tmp//4469158289d8c506ec69128b7e0f2d24.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('34a50d25-8c5b-33fd-92b2-27b94b48c514', '1978-10-25 03:16:42', 'tmp//307bdfae3ba2cfe042a983a45b28ad4d.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('376ca22e-b9b1-378a-bd20-a00853148640', '2016-06-09 07:30:44', 'tmp//ac5515162a0b4b801d8813798d1d102c.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('385ea231-f392-3fef-9b28-173ebf88b731', '1973-02-15 05:43:01', 'tmp//2eaabc518828176ef1019b0aab23f568.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('3a69d23a-af7b-3ca4-a6a7-bc8eeffcb20b', '1995-11-25 05:26:19', 'tmp//80d1b25464741023b65b339aedc03bcf.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('3b8f0705-4fd0-316d-b910-48428f915560', '2012-06-24 14:47:26', 'tmp//121d1cc24fa3568d1550d2dc5a7761f5.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('3ccbfe6d-b234-3e86-bab9-265dda0e2992', '1988-05-31 14:04:45', 'tmp//ab1f1fa39e4e38c7c704cac7171f99b4.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('4085a0bd-8da9-38fb-96c5-8dd99de6dc83', '1998-07-31 07:49:56', 'tmp//62d5de49bea870ed7cb73c84b018f6f2.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('4202d2a2-a8fa-391c-9936-d07c599478b0', '2013-10-20 06:55:53', 'tmp//964dde20f7b3ab5a6735d718741af867.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('44c13a02-f73d-3703-9208-e7103daaa9e1', '2011-05-18 05:17:50', 'tmp//36b8166ad952fcde2cafb961cc3c9f24.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('47fde477-1be2-3e6b-9af4-d5ddba0f215b', '1981-07-29 15:12:00', 'tmp//3c00f44c2943da35b3a1095a5a161b7f.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('4ae22870-d140-3ddc-a3db-7491b6743b2d', '2017-08-30 14:02:34', 'tmp//8618e4595b2732ef9deafc80f83ef820.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('4e1d8909-63ec-3cd6-a72c-c29150cd02a0', '2003-01-09 11:51:45', 'tmp//aa2ad3636e4396c7b52277de1ca8f2fb.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('519f604f-2f3b-33f6-a36b-d42514ea98d8', '1996-01-14 10:44:17', 'tmp//4e1c104d5080fc7cf6bb59bdaa4570ff.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('5fbfe7f1-9ef5-3fee-9d24-440ea9fe8330', '1979-08-10 06:10:04', 'tmp//42ab604debf2a5be01812d398ae4a080.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('61090d20-6c01-3180-8599-3589401f8e70', '1985-12-18 01:07:14', 'tmp//9a96123771f870ceb69f2c6eed48a402.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('63841471-969d-30f2-bf2e-afba0d87369d', '1973-03-30 10:22:23', 'tmp//80a5dd6cdd018eac73fdf117fd001f50.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('68af4aa8-bc94-387e-acc8-2adbe358b8f0', '1984-09-28 10:01:09', 'tmp//8b89f6b7ce8fd27da7ef93735bb99727.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('6ad7748e-939b-3e49-a313-f0751c9f99d2', '1982-07-02 15:31:10', 'tmp//6090777e845e9c550c7a110d13541378.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('6d4b9987-99df-3ec6-9388-605e776a697e', '1975-08-30 14:01:35', 'tmp//1fca8a61b45016f661c8e209ed814d89.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('6fc0554e-bd0c-37cf-805e-62c48b854555', '1987-11-06 13:22:09', 'tmp//d5c658a6908b4a015b3b6e89c9f8121d.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('70b44690-2396-31d6-9211-cfe4c98bd50b', '2006-08-14 16:37:36', 'tmp//1e9a2fe6768687bb6e18b9a3b2dd183e.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('727b1d4e-6e7e-3fa8-afd2-fded642691dc', '1977-12-06 00:07:31', 'tmp//f22895587018d5d418903a6ac3832ae0.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('72ed0c55-712a-3725-ba55-142f86a6003e', '2018-06-28 01:34:56', 'tmp//9c6d55c84a6a3068f90f78b48a478846.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('7360391c-ae9f-3cc5-935d-55f4eab6be2d', '2010-07-08 17:32:39', 'tmp//fdd1d090756ea570ff549ad32494ca42.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('73d437f0-fb86-3e84-8d6f-6e7ccb10bd69', '1973-12-29 01:11:56', 'tmp//cf815b3e47c420652420e610341a0fed.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('77c4d8d3-88ee-3ae2-bbd1-e963348b41a8', '1992-04-26 14:32:17', 'tmp//320da0e381dcc827b7c30701f88babad.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('7b644dab-0817-38ee-ad38-7fb7397c50fb', '1990-06-24 02:49:52', 'tmp//90ae17c11544563e24e16a481a1b2417.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('7d5a3688-217e-3e81-ad8c-77475332ced6', '1986-02-26 18:51:10', 'tmp//35562e04569205c1d99e49626cb09fca.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('7e13a39b-321d-36e2-b846-1f37bb621fee', '1995-01-31 02:08:22', 'tmp//ae1045b82c6c2104cc21b0be3fe5cf8e.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('7e52b998-52e9-3c47-86c3-a07261f5d305', '2001-05-23 06:25:53', 'tmp//3c09504fd921a87eb6c95067a0222472.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('82245be3-14ea-37d8-9f33-8928e5cd4c5d', '1995-05-17 02:46:51', 'tmp//0eb7f5ab6ab7bb5b01e871d093fd0074.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('8257678e-16b7-36e4-8061-292a7b60dc66', '2006-01-11 11:10:00', 'tmp//51003020b6f86bca0e5d806d7240bd96.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('838a95bf-ab01-31fd-969a-7804a7ce3d27', '1972-06-13 04:15:43', 'tmp//9a454221283e270a28f08e30d2f60940.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('8a4a3a7c-96b0-331b-9cb9-0a582e01b6f4', '2011-02-24 18:00:31', 'tmp//88d3a6732e2b2f21e6e9bd30f8baa051.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('8bce3789-76e3-396f-a1fa-fe481daae895', '2009-05-30 13:08:00', 'tmp//ff1ae102d339678e33bbbaefa7762681.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('8f48f420-bfd5-3500-81c3-c47f1b5081bf', '1993-11-19 21:43:27', 'tmp//e27b5f3cc88f41af6c4027fa3a5a389f.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('936017f9-12d4-3e56-8d60-bb8cc6612285', '2019-02-15 20:46:01', 'tmp//131608ae65e779f610ca2e800203b477.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('947ee120-f501-3bf9-af94-0867d5df65ee', '2014-06-17 03:31:20', 'tmp//0d9f3a662bf1b4b5d3dd2af95ee63e19.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('98222bff-b38d-3588-b8a2-de875d466e57', '1993-03-01 02:03:06', 'tmp//07ae11111d58a192098e786dfed95bf0.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('985c7cad-2af5-361f-9e41-c2c8640d2d51', '2018-08-11 21:22:58', 'tmp//47c1d54fd1d52f5cfcfe129cdae3154e.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('a5345ff8-10ff-3fec-86d2-9964dba2e62b', '2019-05-04 06:08:41', 'tmp//7c4e43b0b42dc6a5d68d9875284b4f84.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('a5b7dbcb-e906-312f-8922-fbdcfde1e7f4', '2009-03-12 23:03:54', 'tmp//0f21e73c06fd04a1e5bc86e98527542f.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('a77230a9-0493-34cd-8714-18768d3cb6ca', '2020-12-11 02:34:02', 'tmp//d6df92f9831c947b2c233b08047cf02e.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('ac92dd68-d831-3c1f-92c4-a52319b1fa19', '2003-10-16 01:54:50', 'tmp//a7f800a99e6fac77d4cbf8845cd3603f.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('ae025fa4-df2c-3bd5-9da6-51d80c919bef', '1987-11-08 09:21:29', 'tmp//6496f0b7134c8f790a5aec671d147aeb.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('b083a219-049b-3304-8862-8ab33fc19351', '2013-06-12 09:52:08', 'tmp//c11870831e765b5e59ddaf6de142bf1d.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('b1813d4e-d417-3edd-96a7-4f48874260cf', '2011-09-28 14:39:23', 'tmp//dfda6dde5b1fb2d57cb810ec54bb2470.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('b1a5157f-69f5-3e3f-a64a-f1bd754e09be', '1991-10-15 08:04:19', 'tmp//feb70a5ddb1a02576ff9141c53bb384f.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('b2cd48b5-6dfd-3c6e-8278-9f480cddae61', '1992-08-13 01:36:27', 'tmp//5b522b1bc00da9da490dd33435a6a0ce.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('b2f81522-b1e6-3445-ab38-c291a4749aac', '2016-12-11 05:15:48', 'tmp//70a71f3342940e20da7f87bf6435234c.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('b797e504-0be1-3513-93e2-2c792c248f0d', '1993-09-07 10:12:10', 'tmp//f5cf99f94e17b9384112616eabcd8298.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('b85aede4-4d72-33d2-b5dc-8565f8faa9b7', '1993-11-22 12:27:12', 'tmp//74bedfcaa782adfa12100b78b6b60609.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('bb45ff14-39ca-313a-9821-fe22a30f0ab6', '2014-12-15 01:39:30', 'tmp//47318545a55b2bf1a6afa7af976c2f56.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('c036c3b6-e3b3-3470-95f0-b8290e0aaeed', '1976-10-09 20:10:11', 'tmp//1c6c14e7112b41add77ee0c8dbae3509.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('c27fc098-8f22-3852-a723-900b989d0428', '1979-10-31 04:29:24', 'tmp//d554bf0a0c6ffd4dafaa0629107013b3.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('c2c612d8-a925-332b-87e0-96d30f4d2ca6', '2008-05-03 00:23:38', 'tmp//d60361a76bf6d2771532ffd172b2718b.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('c352bd4e-50dc-3a26-97a5-c1e974932470', '2007-04-24 20:08:33', 'tmp//20b4d3947a9adb74d84bf56a3ac4ee5b.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('c76ad293-8034-3241-8fbc-923e4d9235db', '1997-01-28 15:50:07', 'tmp//e470b8c163a6750c805c491f0f17ed6e.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('c944b1f7-a800-32af-b2fb-b12e37041ffd', '1977-08-25 04:54:43', 'tmp//f933d382d6ca5d1b96103cd99cc68aae.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('ca1b8ab5-b86c-3cdc-8866-3aa7db127dcb', '2001-04-13 03:57:47', 'tmp//9e463cc01bc32f44ce6e67a73b2adf60.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('ca329ceb-b750-3693-9bf6-0929c9937abe', '1995-04-27 01:08:45', 'tmp//8fa04fe32c35214a4559aeb2cb5b7193.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('cb120020-3071-3ad1-8224-1f69e6b2877d', '1991-03-18 17:00:25', 'tmp//66485affacc5aeedbbf2590997a63f07.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('cb50c760-a605-36ba-81f6-c932d24dff24', '2005-06-16 14:14:52', 'tmp//f117c9b91a88ffa8cca6c62aa5bc8c7b.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('cb7b660d-2b3a-365a-8fc2-a174ba11ea96', '2007-09-25 22:34:46', 'tmp//8ce944be6409430fd94ef2a815052014.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('cc0d7093-0ee4-39c2-93c4-48fd9221c035', '1992-06-07 00:05:54', 'tmp//7a8e70caaeeb358abb603bbad841f373.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('cdc4d4e8-9fc4-3fff-9698-979b7fed4960', '2003-08-29 16:11:22', 'tmp//defcdb8808b284acc75a5e73d30bd6dc.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('d1d12092-720b-3c0d-96ef-cace5658c86a', '1977-03-22 17:13:48', 'tmp//c0b9e11437704be83716ff42fc5ed506.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('db8445eb-1f17-3720-bea1-56bcee565192', '2009-08-30 16:02:51', 'tmp//9a966a80e40549d88c5119dff606f14b.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('e5cd4480-d65b-3e4a-88a8-8e641c4dd6c7', '1997-04-11 02:13:46', 'tmp//e65808deb0643795eeeafff7b1df6106.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('e64a984c-9f44-3c57-ba8c-732076e210bb', '1980-09-24 09:00:48', 'tmp//72b8e35def94dbf2b6febbfdbeb1f1a1.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('e6ea9036-3900-3840-b2c9-a4412e84b864', '2002-06-23 21:38:30', 'tmp//e0b26f9ee291e36d74840dcac873551a.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('ebc557d8-f052-3bb9-bf61-2d5e4d01fc66', '1974-09-12 07:38:33', 'tmp//90c158e995d9997f3184d8c7058d9584.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('ebf82ab9-9083-3cb2-9d25-3aae148b95e3', '1971-10-26 06:20:14', 'tmp//2a896ef337a530a1ef303298eaf934bd.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('ed4d5058-2a9a-3a71-a3f3-3dea618d40f0', '2006-07-11 13:57:07', 'tmp//ef6ac0e9fff388665e654b52bd2f3e20.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('f0a08c2d-ebec-3116-98d1-10f3a56848c3', '2015-03-15 17:40:03', 'tmp//9f72edac51aab2af85898cac87a3fd20.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('f39e62d4-bc1c-3460-af51-96e525b40e01', '2004-09-02 07:59:30', 'tmp//85d3067e29fa19f7d3996b8d182b29f6.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('f426ce3e-0439-3e94-a053-9592cc5be1e0', '2012-07-29 19:23:58', 'tmp//a1c953578adee0b17723936d25734d00.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('f7ca4344-c314-3afa-8f93-b5c383073707', '1979-05-08 20:22:24', 'tmp//49f6bfaf6c1eb14450c03effca89aa53.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('f90e7d6d-cf66-3e52-948d-ecfb87161f89', '2003-02-12 08:06:23', 'tmp//9c79b6254c6acde091f0ae8013100669.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('f9e16019-928c-3ea3-b07f-141a114e260a', '2018-06-30 16:55:53', 'tmp//2aa0216ce2d10319d3a6d2dd38f25dfd.jpg');
INSERT INTO `garden_images` (`garden_id`, `timestamp`, `image_path`) VALUES ('fdc6cdf7-ff22-3d9b-b024-18f000364705', '2014-01-22 23:34:42', 'tmp//7dc2213ab8f83202471fd4b936818f02.jpg');


#
# TABLE STRUCTURE FOR: notification_information
#

DROP TABLE IF EXISTS `notification_information`;

CREATE TABLE `notification_information` (
  `garden_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `timestamp` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `notification_type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`garden_id`,`timestamp`),
  CONSTRAINT `garden_id_notification_info` FOREIGN KEY (`garden_id`) REFERENCES `connection_information` (`garden_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('01cc5c7a-1d2c-3af4-b04e-36aee80efd3a', '2009-07-23', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('01f0b9c0-f6e7-3e1e-b231-0afbd1477a11', '1999-02-06', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('0398ae6d-847d-3338-b1e7-9899b8e61775', '1986-06-18', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('09924e3c-368a-3f5b-905f-eded3eb54d6e', '2015-09-03', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('0bea9ce9-d61d-3e8d-908a-b664fb740640', '2012-07-07', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('13052a17-d854-358d-a03d-aa76ddcb3ef9', '2015-12-12', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('13e7e23e-b0aa-36c1-a98a-b15de9fad91e', '2005-11-03', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('16161e0c-dc5a-3e9a-b827-bd8799b1f59c', '1976-11-05', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('170b3e91-7eae-3e01-adb7-0399617f2eb0', '1990-01-19', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('17ab745c-9b80-3a08-a87c-1e7578f6060d', '1998-09-09', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('17b0b581-013f-3617-8f21-5deb33e5553d', '2001-06-27', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('18db64a1-fa31-358d-8be2-746a873ca7ae', '1991-10-27', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('18fbd7e8-e5d7-3db6-abdc-8e18906a4d44', '1992-02-15', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('1a2b85df-971b-3926-8af4-c7a45d190cf6', '2011-01-03', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('1e48f3f6-4810-3223-bb57-5c96ee97eeb6', '1976-01-18', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('23b8ebe9-9afe-31c4-97f0-6c079dc846a5', '1997-01-28', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('2cd7214b-c810-3f3d-8fb6-650d7757ccba', '1979-11-26', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('2fc7e95c-fc02-3390-97c7-65124e88fff3', '1989-12-08', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('3164e7f0-de97-31d1-b99e-bdba9b318d76', '1990-08-01', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('34a50d25-8c5b-33fd-92b2-27b94b48c514', '1976-09-29', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('376ca22e-b9b1-378a-bd20-a00853148640', '2019-07-26', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('385ea231-f392-3fef-9b28-173ebf88b731', '1971-10-20', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('3a69d23a-af7b-3ca4-a6a7-bc8eeffcb20b', '1993-04-14', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('3b8f0705-4fd0-316d-b910-48428f915560', '1975-10-27', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('3ccbfe6d-b234-3e86-bab9-265dda0e2992', '1989-10-05', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('4085a0bd-8da9-38fb-96c5-8dd99de6dc83', '2016-02-06', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('4202d2a2-a8fa-391c-9936-d07c599478b0', '1976-01-19', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('44c13a02-f73d-3703-9208-e7103daaa9e1', '2014-12-16', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('47fde477-1be2-3e6b-9af4-d5ddba0f215b', '1990-11-08', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('4ae22870-d140-3ddc-a3db-7491b6743b2d', '2014-09-09', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('4e1d8909-63ec-3cd6-a72c-c29150cd02a0', '1972-01-01', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('519f604f-2f3b-33f6-a36b-d42514ea98d8', '1991-09-10', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('5fbfe7f1-9ef5-3fee-9d24-440ea9fe8330', '2009-05-15', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('61090d20-6c01-3180-8599-3589401f8e70', '2018-03-13', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('63841471-969d-30f2-bf2e-afba0d87369d', '2005-06-19', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('68af4aa8-bc94-387e-acc8-2adbe358b8f0', '2014-01-10', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('6ad7748e-939b-3e49-a313-f0751c9f99d2', '2004-02-19', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('6d4b9987-99df-3ec6-9388-605e776a697e', '1988-07-26', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('6fc0554e-bd0c-37cf-805e-62c48b854555', '2021-05-08', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('70b44690-2396-31d6-9211-cfe4c98bd50b', '1991-08-27', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('727b1d4e-6e7e-3fa8-afd2-fded642691dc', '2009-01-28', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('72ed0c55-712a-3725-ba55-142f86a6003e', '1992-02-19', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('7360391c-ae9f-3cc5-935d-55f4eab6be2d', '2011-06-23', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('73d437f0-fb86-3e84-8d6f-6e7ccb10bd69', '1971-11-05', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('77c4d8d3-88ee-3ae2-bbd1-e963348b41a8', '1983-11-25', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('7b644dab-0817-38ee-ad38-7fb7397c50fb', '2006-03-13', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('7d5a3688-217e-3e81-ad8c-77475332ced6', '1973-02-16', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('7e13a39b-321d-36e2-b846-1f37bb621fee', '1994-06-14', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('7e52b998-52e9-3c47-86c3-a07261f5d305', '2014-05-05', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('82245be3-14ea-37d8-9f33-8928e5cd4c5d', '2011-03-29', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('8257678e-16b7-36e4-8061-292a7b60dc66', '2018-02-15', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('838a95bf-ab01-31fd-969a-7804a7ce3d27', '1999-04-06', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('8a4a3a7c-96b0-331b-9cb9-0a582e01b6f4', '1978-04-29', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('8bce3789-76e3-396f-a1fa-fe481daae895', '1987-11-09', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('8f48f420-bfd5-3500-81c3-c47f1b5081bf', '1991-07-14', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('936017f9-12d4-3e56-8d60-bb8cc6612285', '2005-12-16', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('947ee120-f501-3bf9-af94-0867d5df65ee', '1972-10-10', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('98222bff-b38d-3588-b8a2-de875d466e57', '2020-02-20', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('985c7cad-2af5-361f-9e41-c2c8640d2d51', '2018-09-19', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('a5345ff8-10ff-3fec-86d2-9964dba2e62b', '1980-07-11', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('a5b7dbcb-e906-312f-8922-fbdcfde1e7f4', '2004-05-29', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('a77230a9-0493-34cd-8714-18768d3cb6ca', '2009-08-21', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('ac92dd68-d831-3c1f-92c4-a52319b1fa19', '1976-09-04', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('ae025fa4-df2c-3bd5-9da6-51d80c919bef', '2011-10-15', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('b083a219-049b-3304-8862-8ab33fc19351', '2010-08-17', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('b1813d4e-d417-3edd-96a7-4f48874260cf', '1973-04-22', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('b1a5157f-69f5-3e3f-a64a-f1bd754e09be', '1970-08-29', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('b2cd48b5-6dfd-3c6e-8278-9f480cddae61', '1988-12-26', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('b2f81522-b1e6-3445-ab38-c291a4749aac', '1979-01-26', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('b797e504-0be1-3513-93e2-2c792c248f0d', '1987-06-03', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('b85aede4-4d72-33d2-b5dc-8565f8faa9b7', '1973-11-25', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('bb45ff14-39ca-313a-9821-fe22a30f0ab6', '1972-08-13', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('c036c3b6-e3b3-3470-95f0-b8290e0aaeed', '2009-01-27', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('c27fc098-8f22-3852-a723-900b989d0428', '1989-07-13', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('c2c612d8-a925-332b-87e0-96d30f4d2ca6', '2011-07-19', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('c352bd4e-50dc-3a26-97a5-c1e974932470', '1994-09-25', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('c76ad293-8034-3241-8fbc-923e4d9235db', '2000-08-25', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('c944b1f7-a800-32af-b2fb-b12e37041ffd', '1975-02-19', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('ca1b8ab5-b86c-3cdc-8866-3aa7db127dcb', '1983-10-12', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('ca329ceb-b750-3693-9bf6-0929c9937abe', '1997-08-18', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('cb120020-3071-3ad1-8224-1f69e6b2877d', '1999-03-27', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('cb50c760-a605-36ba-81f6-c932d24dff24', '2010-02-26', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('cb7b660d-2b3a-365a-8fc2-a174ba11ea96', '2001-01-27', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('cc0d7093-0ee4-39c2-93c4-48fd9221c035', '2010-07-23', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('cdc4d4e8-9fc4-3fff-9698-979b7fed4960', '1971-02-15', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('d1d12092-720b-3c0d-96ef-cace5658c86a', '1997-12-27', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('db8445eb-1f17-3720-bea1-56bcee565192', '1991-11-21', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('e5cd4480-d65b-3e4a-88a8-8e641c4dd6c7', '1974-09-18', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('e64a984c-9f44-3c57-ba8c-732076e210bb', '1984-12-02', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('e6ea9036-3900-3840-b2c9-a4412e84b864', '1997-05-17', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('ebc557d8-f052-3bb9-bf61-2d5e4d01fc66', '2005-10-11', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('ebf82ab9-9083-3cb2-9d25-3aae148b95e3', '1989-09-22', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('ed4d5058-2a9a-3a71-a3f3-3dea618d40f0', '1989-02-06', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('f0a08c2d-ebec-3116-98d1-10f3a56848c3', '1970-07-18', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('f39e62d4-bc1c-3460-af51-96e525b40e01', '1977-09-09', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('f426ce3e-0439-3e94-a053-9592cc5be1e0', '1981-04-26', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('f7ca4344-c314-3afa-8f93-b5c383073707', '1988-02-01', 'water_leak');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('f90e7d6d-cf66-3e52-948d-ecfb87161f89', '1980-03-22', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('f9e16019-928c-3ea3-b07f-141a114e260a', '2006-03-23', 'animal');
INSERT INTO `notification_information` (`garden_id`, `timestamp`, `notification_type`) VALUES ('fdc6cdf7-ff22-3d9b-b024-18f000364705', '2014-10-12', 'water_leak');


#
# TABLE STRUCTURE FOR: registration_request
#

DROP TABLE IF EXISTS `registration_request`;

CREATE TABLE `registration_request` (
  `registration_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `garden_id` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`registration_id`),
  KEY `username_idx` (`username`),
  CONSTRAINT `username_registration_request` FOREIGN KEY (`username`) REFERENCES `user_information` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('036026fd-05c6-31d4-9a4c-57e3c6cd2806', 'ullrich.virginie', '489d9bce-626b-34ac-851d-e3a7d64dbc54');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('0a919d68-28c4-32bb-bd6e-c52e72883150', 'adah.cummings', 'c1e5c6a8-f727-3242-bf6b-287056939e26');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('0c0c5c1f-a865-35f7-962e-ba686ef6e4e4', 'hbotsford', '590cb144-85ff-3614-a69a-e6811dd6488f');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('0c601287-20e8-36af-96e7-0134b7c7684e', 'glover.tod', '9f1137de-d2de-3a61-82a3-cef0829414e4');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('0ee242a6-9523-3ef4-985b-0ebf3880da18', 'awiegand', '05926b90-f005-388e-b2c9-5b0fc9d7594a');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('14dc234e-d799-39e7-af1d-023e5f73ac0c', 'antonetta61', '6766d48b-af02-3518-913d-c7a310ad8610');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('174b146a-fdbb-3506-a178-f0868d58c785', 'era.homenick', '374b61c7-7fe8-3dea-b192-44a60c85b293');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('1b7df6e7-ee2e-3cc7-bc2d-290f1e78213c', 'zaria.heller', '2e47683d-2a33-370d-a64b-be6e0ba36516');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('1f112918-c9f6-3998-9573-f6634c6c5f58', 'celia47', 'ba135b28-d369-3e60-9ec9-4fc71696dad7');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('1fa1366f-2841-3ab6-9475-c7b3912c139f', 'sschmidt', '2d904020-6d48-3174-b851-18ce8e8ec0ad');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('1fbcd3b8-c968-34c0-802b-6c35484f3906', 'wolf.mathilde', '49986625-1c6c-314e-9fe8-84e322bc3e65');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('20972b22-18b1-313d-82b4-c4decc2d15de', 'htorphy', 'd4b3929f-e3c4-3c2a-842a-54360c1039f2');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('2575a697-1cd1-3088-9566-5e4ef4328042', 'hkoch', '3e56faf8-9c98-31df-aec8-1e6b4f071609');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('279ab03f-fd4a-3276-a2a9-87495cdb3cc1', 'sandy.goldner', '69e5fd6d-44b7-3f7b-9ce2-a38c412cec90');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('29af2436-4869-3ca3-b4c3-c9b3947a4449', 'glebsack', '684a23d2-3c09-3543-9179-3f563f93eeb8');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('2d61b98c-69ef-3c86-948e-b6aa839f86dc', 'mbarton', 'ef849ba5-4638-3a7e-84d3-21a36089a506');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('2ee75074-4032-3483-b13d-75e6df9e90ac', 'kub.jasen', '8e5bf5e3-5d85-3234-b842-781523235a18');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('3078e625-1af9-379a-b5e4-adb3c410eb8b', 'davin.murray', 'd5b4838b-4f70-3c89-9936-227d317c1867');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('30d14622-f22c-3c3f-889e-63efec3de614', 'marks.luz', '10e847e9-ce8d-3ddb-8bab-b05aa2b12f32');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('326fab6e-ca20-3bcf-bcc9-0a8abbe59fc0', 'ltremblay', '2ed155ba-3163-32df-b4ca-01fc4444e085');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('365d3d87-341a-3ce0-a5f5-d2e6bddadae9', 'annabelle82', '2afec22f-6e74-3e8a-8f3a-30d003a6b20d');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('3822b511-8b39-3721-a999-070b94120610', 'kwisoky', 'f706713a-863e-3ef4-8caf-963034f23060');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('3bf6c68b-6b07-39ed-aa99-84150100ae5a', 'pouros.edmond', '56fd1f43-0d57-359d-98c8-a8195485f416');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('4283d4fc-59ec-34ea-bcbe-75213c9b72bf', 'felicity76', '1e5589ad-e696-367b-b190-e6fca90caaee');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('46fb7b8b-75f5-3aaa-9114-0862f5fd442b', 'mueller.shaun', 'ec590fc6-6609-3af1-9767-0d3bf1544f90');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('478ca6ac-f8ac-3aaa-b27f-c758aea55ff1', 'kuhlman.adolfo', '38415998-8d35-3362-b319-0c5e53553063');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('4cd1f9e6-77e5-3933-ae47-1d1cf703f9c2', 'xolson', '8ddd633b-38ef-3070-b1d0-1b65292847e1');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('4e88743e-ec96-34ce-a0af-3d54ac7d4beb', 'will.erdman', '51aa341a-1160-3560-8d74-5bd8b9e21445');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('537fcffb-a151-39c1-b9c7-11ef3d7063c3', 'kathryne71', 'b11024b4-3528-3f0e-b738-037d486df0e1');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('54fed271-8918-3ca7-a76f-7925261d0847', 'lura67', '439caad8-712d-3a3a-a0bd-e2e193949022');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('573b01fb-9677-37d7-8853-f26e43287bef', 'uspinka', '04795e9c-28fa-343d-9923-a881136d827f');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('5870ec31-a55e-38e3-ad8e-1a8677a5e105', 'ondricka.justen', 'b6db4c29-a87c-36d9-b72f-f0c9fcbd254c');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('5cd1a0e9-ba74-3f78-a192-57c0c58d2bee', 'lsmith', '5d319ffa-c8ff-30c6-a049-0686087e97b5');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('5de4adc6-edb1-320d-b007-e09d28ba999b', 'jazlyn.bosco', '036f092f-d524-3dfb-b1fd-423276357d1f');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('61b7bce5-645a-374c-9f16-0f6ecceb029a', 'emmet.boehm', '5caf9fbd-ab4b-36df-8e91-966835599195');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('644fff20-1cbb-3494-9ba7-e4842ab84149', 'ikuhlman', '00c83dc8-1148-334a-8434-1516fb009076');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('6514e2d8-39ce-3c1c-bf1e-6cab41db6f4d', 'sandrine.schamberger', '9c58b6b4-26ab-3212-b2e2-fbfcdb74a86b');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('66ab56b9-dcce-3673-b50a-57037004fc60', 'gerard04', '7bf4664c-d6d7-3c93-bb57-41a7aba0fb28');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('671026f5-f539-38d6-89b0-8be505eb2800', 'lacey95', '60c88943-8fac-308c-be9f-843ffe2ecf90');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('6a62e6d0-59ae-3b3d-8c5a-0dec2b5b5e35', 'gaston12', '55080607-6337-3e45-8efd-309edd33d432');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('6b408134-6db8-31ff-bce1-6501f9a0c192', 'chirthe', '0c352391-4b1e-3b32-8591-a7eb876e1b29');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('6c8e1bf3-f70b-38cb-a276-913ab18ebefa', 'wjohns', '46107449-a8f7-3afd-bb2f-10ec33423f07');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('75c24fca-3cf5-3754-b360-7d7644073b80', 'prudence21', 'e933aa01-72e9-3a95-953e-eb392d73cefc');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('7833b192-ffaf-30ac-8d62-d15593ebe7ef', 'alisha86', '78f5421f-fefb-32b0-8953-0548cbc918d7');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('7d1e9dc0-ab69-3e3b-91c1-45576ddbca1b', 'ewald75', '08f26b48-cbd2-3593-b906-af50b349dad9');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('8369c984-35f8-3a73-9661-f7b00b961906', 'joana.flatley', 'baca8c1e-f688-30dd-b697-63e0e6b552bc');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('84ad8c31-c5d6-342c-99b8-e1b53fc2f242', 'ddaniel', '53a80989-ea99-32ce-8f4e-9a474976ad8a');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('86f70180-6326-3a62-a0c9-a152e6142a0d', 'rutherford.tara', '321201de-99b8-3c47-94ee-aff296de4373');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('87860de5-2c46-3822-8e65-c34e69ae0756', 'ron.tillman', 'd9ad3587-701f-3fd9-a650-452db467d48c');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('8a46c5eb-5d82-3062-98ba-e8941f7377e8', 'lakin.brannon', '7bc17d1c-4498-3a59-91c3-cff5188766ee');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('8a9b1a50-5c7e-3288-89c8-2935e88c2c88', 'kiehn.chris', '0214c510-5d8d-30a3-8fbf-f390ed715079');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('8b0bbee6-285c-3072-a9db-161549b642a7', 'nicole.wilkinson', '8c9310ea-1e6e-3fc0-9b0e-807a20e9e8e1');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('8d556458-7f90-3396-85e2-46a06417a434', 'kortiz', 'f2f8ee5e-fd7e-32ed-9e66-6a25145b716d');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('8e93b03f-b447-3b18-acd0-62feb1e34192', 'wehner.sage', '7ff72053-a3ab-3996-88c4-571a4d89f204');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('8ec3d396-a040-32c3-8116-658b6ec98baa', 'shaun.rowe', 'b57c9e4b-58af-34ad-a312-9af2c663963c');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('9486706e-30f0-3af7-9b4d-a8cc18b33112', 'ernesto82', 'b796cfd6-648a-3a64-9fbe-05bbd762527d');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('98a70ae6-031d-3b97-b299-c7d879c0a6ee', 'taryn.effertz', '8ea68434-fd94-35cc-8f7e-4453f4ddf878');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('a1ce56e6-adad-314f-8194-0eadaea14092', 'sydnie37', 'b94fdd87-55bc-32cf-805d-0dcf0ca82b64');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('a46fad55-7bb6-3675-a943-3668b3091529', 'mitchell.jameson', '323eea34-9687-35af-bfa8-073fb8f9148a');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('a58e6948-bec0-3d32-83ce-4dd9ccf309e0', 'elmo.langosh', 'abdcc0c1-a3a5-3ee2-b996-14e8d9663ff6');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('aab37102-2189-38c3-a3ee-15eedb6e3185', 'alek09', '9ff01315-31c4-32bd-b7ed-b4eecdf10e1f');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('b0639b98-857e-3d29-97c5-3f53fe69e994', 'batz.antone', '5a9511f6-f551-30b1-9c77-95e67cad6815');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('b188a731-1dc2-382c-8095-8cb3bffd133a', 'julien38', '2f9eed05-1d97-32df-be43-7f1d433be998');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('b444465c-fbb5-39df-b753-ef7260460266', 'gaston.wintheiser', 'b4c2dd4a-4ea3-3591-b04b-c4d83e171a98');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('b7237f1f-1d02-37a8-a6cf-44a2ac08a427', 'moen.melisa', '9564724f-addd-3f1d-a03d-ee11ace0f1b8');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('b74447b9-3454-328f-b628-ef985cba808f', 'stroman.eudora', 'a14c5cb4-942b-323c-b914-56c7f3981645');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('bc306a6c-3f6d-3936-aadf-69720549cf73', 'toy.bertram', '02918cc9-dd96-340c-86af-7bfe7857a36a');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('c6303e7e-dc00-39b6-ac60-10a4110003fc', 'isabella.kessler', '106b7477-5e89-31b5-b92e-c46d69edcedd');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('c9b99794-683b-3f2d-8e1e-475da1e3844d', 'nwisozk', 'd4aa37c3-352a-3bcd-be5e-df25ddadb25b');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('ca308829-93bd-30fc-bbd5-d30dbe5f2461', 'shaina.wisoky', '17579dd4-82a7-3342-941a-062dd072ad83');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('ccbf5adf-26cb-312a-870b-13c9bb2c03fb', 'ophelia74', 'c6d11e50-2ef8-3f7a-81a6-b0e14cf16642');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('ccfa8225-92c0-3399-84b1-f07fb4ae3361', 'easter21', '61270d06-2a4d-3cbe-9bcb-6518f0f4aebc');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('cd79d231-2e3e-31a6-bd1c-9048f3b9eae2', 'maritza.wisozk', 'c341bce2-fe93-31a9-aefe-a60674aaaaf7');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('d09a15c5-547e-39c5-9868-326340753374', 'maxine68', '5108ce9a-2f9d-3f76-8fc2-1b35142942cb');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('d14c36fc-47fe-395c-b08b-cd3a59086ca9', 'ycrooks', 'ac525dd8-5d63-3739-937d-c5e17b799e37');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('d14cd40c-1102-369b-822f-37da34aef5c7', 'ashleigh.stark', '951a68c2-b0ed-30f7-951d-9a1b90c249ec');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('d2283501-236f-3784-996d-751501d691cd', 'hessel.christop', '3a0ea9b0-f0d3-30b3-8432-911392ff8774');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('d284eec4-2e4d-3876-b47d-1541b021f29b', 'rhansen', '71a07ebb-3133-3f9c-b8b3-2df7ebb005a0');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('d32b923e-ea9b-33a2-897c-708399d6b07e', 'ondricka.august', '9f052a7d-4db9-3abf-9671-c359f7f1910f');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('d3b7669e-dcf1-3886-8821-383a5faf0968', 'ikessler', 'f317e1ee-1b91-33c7-b1bd-753a4dcd0b5f');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('da89af99-b61e-3a27-a2af-64eab5fcc5f6', 'tfadel', '63ae0fc5-29f8-3cec-a1bf-67b1e88ae689');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('dd01e40e-81d0-305f-bb6b-a57bcc0aa523', 'xyost', '8af35d5e-ea80-37cf-96b4-dd28b09cd54a');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('dd42a071-eb09-38b8-b75f-f5d532277385', 'sedrick34', '2d724d11-7ff2-3dc1-bdad-496cf7603991');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('e43355a1-0aed-339d-aa80-a80eb9af4755', 'ashly.gerlach', 'e7d318ba-00e0-3252-ad3e-eebc0b2b358d');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('e6488de3-21e5-33ee-8ad7-b33f4356bf09', 'mohr.deborah', '2ea31ea4-c726-3b8e-965e-c9fe8e1b5b38');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('e674746b-377a-34a9-b4cd-b90dc2329e28', 'nsenger', 'c769c966-a508-30cb-9140-1fd801e840f5');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('e88922ef-cb3a-340e-a7c5-cb091bc4fd46', 'adele32', '7d4ce5a6-8476-3fa7-9c29-b2b9ae281e3c');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('e8b7d93e-e8b1-3e50-b965-71eb58c2011f', 'jeramie09', 'ab8c61b7-c702-35c5-9913-dcede9e775d0');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('eaca5c4a-0f83-3356-9141-dd920fc08ec1', 'jesse.walker', 'c4a00067-93a1-3f84-9d5d-9cfd82ba0008');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('f03ed0b5-92cd-3a9f-9700-fc32c3d2c1b5', 'alysa.kilback', '5704495d-5dca-3231-8332-85edba81cd5b');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('f0ee72ce-2748-3a46-9ff9-bd5a6535ce46', 'quinten30', '2855a6c8-e582-3b8d-ad03-3cd89eb4897e');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('f14f6473-3a05-3663-8ea2-7b57a6bd6190', 'greichel', '2a4c23c3-f770-3cb6-9c6d-3598a8862d51');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('f17c6dca-1cca-347f-aa5a-f08a27f995ff', 'pearline.schmidt', '791a1f39-2947-3602-b375-3a73b5026a03');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('f3b4ab66-77d3-3032-bde3-4745c2bc0739', 'qrowe', '8633a126-df73-35d7-adf5-bba24ad6e0c5');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('f4aa91d8-9aa4-3b2e-a7bc-84b956d17e81', 'darion56', '9cac5335-0e28-3954-96ad-a50c5723ec1d');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('f4dc99b4-cdc9-32c1-a052-048cfd62d776', 'zquigley', '34c8e769-3641-3132-932c-ff1cd85109b2');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('f5a0764d-f251-3c68-89e1-8fd083adc8d9', 'freida11', 'b3c854a6-8671-3820-ac59-22ea8da60c30');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('f5e1b3d8-79c5-31ca-8de7-3caa3839fc6e', 'dennis20', '45a562b6-74bd-380a-98fb-5bf516202a4f');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('feaf8501-adb3-3179-8c9d-2bd4cfd6de55', 'jenifer.moen', 'ab8e70cc-b759-3bf9-aa11-2edfeb2f78d5');
INSERT INTO `registration_request` (`registration_id`, `username`, `garden_id`) VALUES ('ff60849d-cf1e-34ce-ba93-c78b31547053', 'vtowne', '70f71fc6-5d38-3044-8099-87fcd7c3671e');


#
# TABLE STRUCTURE FOR: sensor_data
#

DROP TABLE IF EXISTS `sensor_data`;

CREATE TABLE `sensor_data` (
  `garden_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `water_flow` int(11) DEFAULT NULL,
  `humidity` int(11) DEFAULT NULL,
  `soil_moisture` int(11) DEFAULT NULL,
  `temperature` int(11) DEFAULT NULL,
  `water_active` int(11) DEFAULT NULL,
  PRIMARY KEY (`garden_id`,`timestamp`),
  CONSTRAINT `garden_id` FOREIGN KEY (`garden_id`) REFERENCES `connection_information` (`garden_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('01cc5c7a-1d2c-3af4-b04e-36aee80efd3a', '1990-08-21 02:02:21', 9, 49, 16, 36, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('01f0b9c0-f6e7-3e1e-b231-0afbd1477a11', '2007-07-11 23:18:30', 5, 39, 6, 98, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('0398ae6d-847d-3338-b1e7-9899b8e61775', '2010-12-06 15:19:12', 10, 73, 12, 86, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('09924e3c-368a-3f5b-905f-eded3eb54d6e', '2016-01-22 17:20:05', 2, 22, 2, 55, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('0bea9ce9-d61d-3e8d-908a-b664fb740640', '2006-10-23 22:26:01', 2, 21, 5, 90, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('13052a17-d854-358d-a03d-aa76ddcb3ef9', '1982-12-26 21:32:18', 7, 112, 27, 83, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('13e7e23e-b0aa-36c1-a98a-b15de9fad91e', '1976-11-28 02:53:10', 9, 48, 11, 109, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('16161e0c-dc5a-3e9a-b827-bd8799b1f59c', '1976-01-23 05:15:48', 10, 84, 16, 99, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('170b3e91-7eae-3e01-adb7-0399617f2eb0', '1984-07-26 18:21:42', 7, 50, 26, 46, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('17ab745c-9b80-3a08-a87c-1e7578f6060d', '2010-08-27 11:08:22', 2, 82, 18, 89, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('17b0b581-013f-3617-8f21-5deb33e5553d', '2019-07-03 18:44:32', 4, 25, 24, 57, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('18db64a1-fa31-358d-8be2-746a873ca7ae', '1983-06-17 16:43:50', 4, 74, 16, 48, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('18fbd7e8-e5d7-3db6-abdc-8e18906a4d44', '1998-02-04 03:57:40', 3, 90, 12, 106, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('1a2b85df-971b-3926-8af4-c7a45d190cf6', '1974-04-05 20:48:56', 6, 104, 10, 37, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('1e48f3f6-4810-3223-bb57-5c96ee97eeb6', '2003-09-12 21:42:17', 3, 100, 2, 30, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('23b8ebe9-9afe-31c4-97f0-6c079dc846a5', '2016-05-06 12:28:48', 3, 52, 4, 99, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('2cd7214b-c810-3f3d-8fb6-650d7757ccba', '1981-02-08 03:25:05', 2, 109, 16, 77, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('2fc7e95c-fc02-3390-97c7-65124e88fff3', '1972-09-10 13:09:41', 5, 74, 15, 30, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('3164e7f0-de97-31d1-b99e-bdba9b318d76', '1994-07-07 16:14:33', 3, 56, 27, 93, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('34a50d25-8c5b-33fd-92b2-27b94b48c514', '1998-06-04 06:25:26', 3, 43, 10, 106, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('376ca22e-b9b1-378a-bd20-a00853148640', '1994-11-13 23:04:10', 4, 38, 7, 43, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('385ea231-f392-3fef-9b28-173ebf88b731', '1982-11-19 19:57:00', 9, 112, 5, 61, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('3a69d23a-af7b-3ca4-a6a7-bc8eeffcb20b', '2018-08-29 08:21:42', 10, 36, 29, 95, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('3b8f0705-4fd0-316d-b910-48428f915560', '1999-09-05 17:02:14', 7, 107, 30, 110, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('3ccbfe6d-b234-3e86-bab9-265dda0e2992', '1983-01-16 07:11:48', 2, 110, 19, 90, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('4085a0bd-8da9-38fb-96c5-8dd99de6dc83', '1973-09-02 08:37:52', 1, 120, 1, 84, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('4202d2a2-a8fa-391c-9936-d07c599478b0', '1989-11-13 01:14:05', 1, 92, 13, 33, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('44c13a02-f73d-3703-9208-e7103daaa9e1', '1991-11-13 06:34:44', 4, 61, 24, 70, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('47fde477-1be2-3e6b-9af4-d5ddba0f215b', '1974-07-04 11:51:03', 5, 62, 20, 58, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('4ae22870-d140-3ddc-a3db-7491b6743b2d', '1986-02-17 09:13:52', 2, 98, 5, 105, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('4e1d8909-63ec-3cd6-a72c-c29150cd02a0', '2009-07-12 05:09:10', 3, 120, 10, 93, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('519f604f-2f3b-33f6-a36b-d42514ea98d8', '1971-11-09 04:21:22', 2, 71, 4, 51, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('5fbfe7f1-9ef5-3fee-9d24-440ea9fe8330', '1978-10-13 23:45:09', 3, 25, 26, 54, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('61090d20-6c01-3180-8599-3589401f8e70', '2018-10-29 10:41:06', 8, 39, 17, 96, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('63841471-969d-30f2-bf2e-afba0d87369d', '2016-04-07 12:03:02', 5, 72, 5, 42, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('68af4aa8-bc94-387e-acc8-2adbe358b8f0', '1986-07-19 01:54:43', 2, 101, 30, 33, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('6ad7748e-939b-3e49-a313-f0751c9f99d2', '2012-05-03 03:20:53', 1, 34, 3, 100, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('6d4b9987-99df-3ec6-9388-605e776a697e', '2010-12-17 09:28:21', 9, 77, 9, 84, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('6fc0554e-bd0c-37cf-805e-62c48b854555', '2005-10-10 18:35:54', 9, 75, 4, 58, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('70b44690-2396-31d6-9211-cfe4c98bd50b', '1988-07-09 09:24:14', 6, 38, 19, 93, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('727b1d4e-6e7e-3fa8-afd2-fded642691dc', '1971-11-22 09:22:40', 5, 82, 2, 58, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('72ed0c55-712a-3725-ba55-142f86a6003e', '1975-11-21 07:25:07', 9, 88, 29, 106, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('7360391c-ae9f-3cc5-935d-55f4eab6be2d', '1993-05-19 03:56:11', 4, 89, 27, 72, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('73d437f0-fb86-3e84-8d6f-6e7ccb10bd69', '2020-09-21 13:28:02', 1, 93, 26, 108, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('77c4d8d3-88ee-3ae2-bbd1-e963348b41a8', '1980-04-09 15:51:17', 2, 42, 21, 88, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('7b644dab-0817-38ee-ad38-7fb7397c50fb', '1986-09-20 03:03:32', 1, 69, 26, 51, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('7d5a3688-217e-3e81-ad8c-77475332ced6', '2011-10-27 05:00:11', 2, 55, 26, 94, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('7e13a39b-321d-36e2-b846-1f37bb621fee', '1980-01-24 20:33:53', 10, 66, 21, 69, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('7e52b998-52e9-3c47-86c3-a07261f5d305', '2014-11-20 22:32:17', 0, 66, 1, 79, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('82245be3-14ea-37d8-9f33-8928e5cd4c5d', '2003-05-27 21:29:21', 5, 42, 16, 46, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('8257678e-16b7-36e4-8061-292a7b60dc66', '1988-08-06 15:22:47', 5, 22, 22, 36, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('838a95bf-ab01-31fd-969a-7804a7ce3d27', '1985-10-31 10:31:03', 1, 89, 1, 45, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('8a4a3a7c-96b0-331b-9cb9-0a582e01b6f4', '1979-02-12 19:03:55', 0, 34, 16, 64, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('8bce3789-76e3-396f-a1fa-fe481daae895', '2014-10-11 07:15:11', 9, 97, 10, 44, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('8f48f420-bfd5-3500-81c3-c47f1b5081bf', '1987-02-10 07:34:43', 1, 48, 17, 105, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('936017f9-12d4-3e56-8d60-bb8cc6612285', '1998-06-08 00:28:52', 7, 33, 16, 91, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('947ee120-f501-3bf9-af94-0867d5df65ee', '1982-09-13 17:04:51', 10, 49, 20, 52, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('98222bff-b38d-3588-b8a2-de875d466e57', '1986-04-15 07:14:25', 4, 106, 5, 37, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('985c7cad-2af5-361f-9e41-c2c8640d2d51', '2007-01-26 18:15:55', 4, 31, 15, 89, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('a5345ff8-10ff-3fec-86d2-9964dba2e62b', '1987-09-17 12:48:18', 6, 60, 23, 72, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('a5b7dbcb-e906-312f-8922-fbdcfde1e7f4', '2011-03-08 09:50:46', 3, 53, 19, 87, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('a77230a9-0493-34cd-8714-18768d3cb6ca', '2001-02-23 04:04:27', 3, 76, 20, 75, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('ac92dd68-d831-3c1f-92c4-a52319b1fa19', '2009-07-28 01:31:43', 5, 53, 14, 79, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('ae025fa4-df2c-3bd5-9da6-51d80c919bef', '1977-09-07 02:39:44', 6, 68, 19, 59, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('b083a219-049b-3304-8862-8ab33fc19351', '1989-12-03 06:36:37', 10, 97, 2, 106, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('b1813d4e-d417-3edd-96a7-4f48874260cf', '1984-09-24 13:08:17', 4, 63, 20, 37, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('b1a5157f-69f5-3e3f-a64a-f1bd754e09be', '1982-07-14 23:20:07', 3, 46, 17, 60, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('b2cd48b5-6dfd-3c6e-8278-9f480cddae61', '1974-01-18 09:46:26', 3, 109, 18, 55, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('b2f81522-b1e6-3445-ab38-c291a4749aac', '1996-05-13 15:18:31', 7, 52, 23, 53, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('b797e504-0be1-3513-93e2-2c792c248f0d', '1998-08-04 13:27:06', 2, 64, 3, 90, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('b85aede4-4d72-33d2-b5dc-8565f8faa9b7', '1987-11-25 10:39:15', 4, 114, 17, 57, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('bb45ff14-39ca-313a-9821-fe22a30f0ab6', '1981-01-21 11:47:05', 1, 89, 15, 70, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('c036c3b6-e3b3-3470-95f0-b8290e0aaeed', '1987-03-21 14:02:54', 3, 102, 0, 66, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('c27fc098-8f22-3852-a723-900b989d0428', '1979-04-11 07:37:58', 2, 57, 17, 46, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('c2c612d8-a925-332b-87e0-96d30f4d2ca6', '1999-09-12 23:39:56', 9, 44, 27, 32, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('c352bd4e-50dc-3a26-97a5-c1e974932470', '1970-04-01 13:59:02', 8, 102, 13, 73, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('c76ad293-8034-3241-8fbc-923e4d9235db', '1979-05-04 01:27:56', 8, 40, 10, 35, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('c944b1f7-a800-32af-b2fb-b12e37041ffd', '2015-08-21 13:26:32', 10, 52, 17, 95, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('ca1b8ab5-b86c-3cdc-8866-3aa7db127dcb', '1984-12-17 07:11:47', 1, 109, 6, 94, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('ca329ceb-b750-3693-9bf6-0929c9937abe', '1974-12-12 04:04:52', 1, 78, 8, 100, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('cb120020-3071-3ad1-8224-1f69e6b2877d', '2003-01-26 10:17:30', 9, 113, 29, 77, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('cb50c760-a605-36ba-81f6-c932d24dff24', '1986-04-05 04:02:43', 2, 109, 28, 106, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('cb7b660d-2b3a-365a-8fc2-a174ba11ea96', '1972-11-04 13:42:10', 2, 71, 28, 79, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('cc0d7093-0ee4-39c2-93c4-48fd9221c035', '2013-10-04 20:35:50', 3, 117, 27, 39, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('cdc4d4e8-9fc4-3fff-9698-979b7fed4960', '1985-07-09 00:05:22', 9, 83, 3, 101, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('d1d12092-720b-3c0d-96ef-cace5658c86a', '2002-06-17 08:16:25', 9, 20, 29, 69, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('db8445eb-1f17-3720-bea1-56bcee565192', '2012-03-19 08:53:25', 0, 52, 3, 68, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('e5cd4480-d65b-3e4a-88a8-8e641c4dd6c7', '2018-06-19 17:38:13', 3, 116, 13, 41, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('e64a984c-9f44-3c57-ba8c-732076e210bb', '2021-09-14 06:41:52', 5, 72, 28, 52, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('e6ea9036-3900-3840-b2c9-a4412e84b864', '1980-09-16 20:38:24', 4, 49, 7, 101, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('ebc557d8-f052-3bb9-bf61-2d5e4d01fc66', '1970-05-23 01:15:13', 1, 49, 23, 87, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('ebf82ab9-9083-3cb2-9d25-3aae148b95e3', '1974-07-09 18:54:22', 5, 72, 17, 58, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('ed4d5058-2a9a-3a71-a3f3-3dea618d40f0', '1979-04-18 21:41:06', 7, 45, 23, 106, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('f0a08c2d-ebec-3116-98d1-10f3a56848c3', '2004-07-04 21:06:12', 1, 88, 1, 96, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('f39e62d4-bc1c-3460-af51-96e525b40e01', '2015-07-11 11:10:53', 3, 68, 1, 36, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('f426ce3e-0439-3e94-a053-9592cc5be1e0', '2005-01-02 05:11:09', 6, 89, 24, 89, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('f7ca4344-c314-3afa-8f93-b5c383073707', '1984-11-10 11:53:39', 4, 101, 16, 77, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('f90e7d6d-cf66-3e52-948d-ecfb87161f89', '2003-11-13 06:49:10', 10, 93, 16, 52, 1);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('f9e16019-928c-3ea3-b07f-141a114e260a', '1983-05-23 15:45:55', 4, 74, 4, 65, 0);
INSERT INTO `sensor_data` (`garden_id`, `timestamp`, `water_flow`, `humidity`, `soil_moisture`, `temperature`, `water_active`) VALUES ('fdc6cdf7-ff22-3d9b-b024-18f000364705', '1998-01-02 04:40:12', 2, 59, 27, 46, 1);




