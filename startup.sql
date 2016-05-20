/*
create database craftwarewebapp;
*/

insert into role (id, name) values (1, 'USER');
insert into role (id, name) values (2, 'ADMIN');

insert into user (id, password, username, role_id) values (1, 'password', 'albert', 1);
insert into user (id, password, username, role_id) values (2, 'password', 'craftware', 2);

/* user with id = 1 */
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (1, 8186, 'Pink', true, '919891501-0', 'Ford', 'F-150', '2005-08-18', 162940, 3, '2011-06-11', 1);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (3, 4166, 'Green', true, '227592024-2', 'Toyota', 'Tacoma', '2011-06-28', 174328, 3, '2003-09-16', 1);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (5, 8554, 'Teal', true, '396506649-8', 'Ford', 'F-150', '2002-10-29', 31982, 2, '2006-10-21', 1);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (6, 7317, 'Blue', true, '379747457-1', 'Chevrolet', 'Colorado', '2008-04-26', 127587, 2, '2001-02-12', 1);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (10, 4375, 'Puce', true, '111112725-5', 'Chevrolet', 'Colorado', '2012-02-28', 112566, 1, '2006-02-25', 1);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (13, 2402, 'Puce', true, '762403468-9', 'Ford', 'F-150', '2010-07-24', 130883, 0, '2013-01-13', 1);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (15, 7831, 'Turquoise', true, '063327534-4', 'Toyota', 'Tacoma', '2008-06-14', 149950, 2, '2016-04-16', 1);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (16, 6609, 'Turquoise', true, '326892672-X', 'GMC', 'Sierra', '2013-10-30', 4133, 3, '2007-09-09', 1);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (17, 2106, 'Fuscia', true, '041064109-X', 'Ford', 'F-150', '2007-10-08', 11102, 0, '2007-09-21', 1);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (20, 7372, 'Mauv', true, '496140279-6', 'GMC', 'Sierra', '2011-09-29', 104581, 1, '2007-04-19', 1);

/* user with id = 2 */
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (2, 3057, 'Red', true, '554588019-4', 'Chevrolet', 'Colorado', '2014-11-19', 154873, 3, '2014-08-10', 2);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (4, 5330, 'Purple', true, '147088833-5', 'GMC', 'Sierra', '2002-09-07', 154366, 2, '2014-01-06', 2);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (7, 1026, 'Yellow', true, '531421072-X', 'Toyota', 'Tacoma', '2004-12-16', 37188, 3, '2010-09-18', 2);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (8, 3298, 'Khaki', true, '493347314-5', 'GMC', 'Sierra', '2014-01-16', 163349, 3, '2001-09-16', 2);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (9, 3713, 'Turquoise', true, '740645695-6', 'Ford', 'F-150', '2016-01-30', 52899, 2, '2008-03-23', 2);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (11, 3368, 'Orange', true, '356291811-9', 'Toyota', 'Tacoma', '2010-11-22', 4826, 2, '2004-11-18', 2);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (12, 9950, 'Pink', true, '621786375-8', 'GMC', 'Sierra', '2006-01-11', 174715, 1, '2004-08-30', 2);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (14, 9974, 'Crimson', true, '992176164-1', 'Chevrolet', 'Colorado', '2001-07-10', 34741, 2, '2006-12-10', 2);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (18, 2021, 'Green', true, '235765115-6', 'Chevrolet', 'Colorado', '2009-11-12', 113968, 1, '2001-11-01', 2);
insert into vehicle (id, dotnumber, color, delete_flag, license_plate_number, make, model, purchase_date, purchase_mileage, status, year, user_id) values (19, 2934, 'Fuscia', true, '081757619-3', 'Toyota', 'Tacoma', '2013-01-09', 47980, 0, '2008-11-04', 2);

/* user with id = 1 */
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (2, 0, '2008-12-25', 9419, '2005-04-10', 94952, 1, 1);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (3, 0, '2005-06-17', 3799, '2016-01-12', 127905, 1, 3);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (4, 0, '2005-05-05', 3318, '2004-02-02', 103332, 1, 5);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (5, 0, '2013-08-01', 9609, '2005-12-02', 54594, 1, 6);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (6, 1, '2009-07-14', 3888, '2009-09-08', 54232, 1, 10);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (7, 1, '2002-02-08', 4215, '2003-06-30', 108522, 1, 13);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (9, 0, '2009-09-14', 8339, '2011-01-11', 182685, 1, 15);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (10, 0, '2007-02-01', 7783, '2013-12-30', 124511, 1, 16);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (11, 0, '2002-04-03', 2461, '2003-04-22', 177260, 1, 17);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (17, 0, '2008-11-27', 910, '2003-02-19', 127862, 1, 20);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (20, 0, '2006-03-23', 9058, '2004-12-25', 83123, 1, 1);

/* user with id = 2 */
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (1, 0, '2005-04-23', 8238, '2013-09-14', 121232, 2, 2);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (8, 0, '2006-01-06', 7416, '2004-05-25', 77175, 2, 4);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (12, 0, '2009-10-30', 7668, '2013-01-05', 181854, 2, 7);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (13, 1, '2008-01-13', 1929, '2012-01-12', 151647, 2, 8);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (14, 1, '2012-05-03', 9612, '2012-11-26', 62249, 2, 9);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (15, 1, '2003-07-25', 9491, '2007-05-09', 117526, 2, 11);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (16, 0, '2006-03-17', 1094, '2003-12-19', 181417, 2, 12);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (18, 1, '2004-12-02', 4953, '2008-10-19', 149315, 2, 14);
insert into vehicle_inspection (id, inspection_result, inspection_date, inspection_document_number, inspection_expiration_date, inspection_mileage, user_id, vehicle_id) values (19, 1, '2006-12-07', 6693, '2001-03-12', 54833, 2, 18;

/* user with id = 1 */
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (4, '2014-05-25', 1682, '2014-03-27', 158980, 1, 1);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (5, '2006-07-21', 2512, '2014-06-02', 60603, 1, 3);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (7, '2010-06-23', 9702, '2011-09-29', 112053, 1, 5);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (8, '2005-02-15', 3747, '2006-11-26', 70889, 1, 6);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (12, '2003-02-08', 5746, '2010-01-26', 48359, 1, 10);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (14, '2002-03-22', 8714, '2001-01-16', 67092, 1, 13);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (16, '2015-07-14', 8590, '2015-05-05', 218040, 1, 15);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (17, '2007-09-09', 2902, '2011-01-14', 122741, 1, 16);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (18, '2007-12-29', 9948, '2009-06-05', 224251, 1, 17);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (19, '2008-10-31', 6552, '2006-11-14', 197725, 1, 20);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (20, '2001-11-13', 8856, '2013-03-19', 66786, 1, 1);

/* user with id = 2 */
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (1, '2003-12-11', 6569, '2015-10-08', 52789, 2, 2);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (2, '2012-12-31', 8161, '2003-07-19', 186131, 2, 4);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (3, '2005-09-05', 6660, '2010-01-24', 242670, 2, 7);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (6, '2001-06-14', 2914, '2007-09-28', 13801, 2, 8);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (9, '2002-05-13', 2780, '2002-12-26', 144794, 2, 9);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (10, '2002-10-15', 624, '2009-12-06', 79983, 2, 11);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (11, '2011-09-24', 1914, '2006-01-22', 129541, 2, 12);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (13, '2007-12-14', 842, '2010-02-12', 114612, 2, 14);
insert into vehicle_registration (id, registration_date, registration_document_number, registration_expiration_date, registration_mileage, user_id, vehicle_id) values (15, '2006-04-04', 6017, '2003-11-20', 39046, 2, 18);

/* user with id = 1 */
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (1, true, 'dkennedy0@multiply.com', 'Dennis', 'Kennedy', '63-(305)761-3655', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (2, true, 'mbrooks1@sciencedirect.com', 'Mark', 'Brooks', '86-(178)250-2506', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (3, true, 'alee2@booking.com', 'Anna', 'Lee', '57-(528)409-2053', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (5, true, 'jalvarez4@mapy.cz', 'Justin', 'Alvarez', '591-(688)159-6473', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (6, true, 'wboyd5@cnet.com', 'Wayne', 'Boyd', '86-(809)144-0433', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (7, true, 'cscott6@1und1.de', 'Carol', 'Scott', '62-(933)779-8885', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (8, true, 'jnelson7@google.co.uk', 'Joan', 'Nelson', '63-(610)941-5145', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (10, true, 'dgibson9@drupal.org', 'David', 'Gibson', '63-(100)171-3540', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (11, true, 'abrowna@discovery.com', 'Angela', 'Brown', '7-(735)131-1146', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (12, true, 'arichardsb@nba.com', 'Anna', 'Richards', '375-(108)640-9095', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (14, true, 'khuntd@google.com.hk', 'Kathy', 'Hunt', '57-(344)112-0636', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (16, true, 'acunninghamf@yahoo.co.jp', 'Antonio', 'Cunningham', '63-(906)155-0238', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (17, true, 'rjamesg@newsvine.com', 'Roy', 'James', '1-(317)350-0208', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (18, true, 'jbrownh@google.com.au', 'Jonathan', 'Brown', '86-(152)257-5551', 1);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (19, true, 'jbrowni@blogtalkradio.com', 'Joseph', 'Brown', '63-(839)979-8340', 1);

/* user with id = 2 */
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (4, true, 'kwood3@fc2.com', 'Kevin', 'Wood', '86-(205)291-2187', 2);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (9, true, 'lgray8@a8.net', 'Lawrence', 'Gray', '62-(117)201-2401', 2);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (13, true, 'swalkerc@mozilla.com', 'Sharon', 'Walker', '62-(163)368-6605', 2);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (15, true, 'pwagnere@wunderground.com', 'Patricia', 'Wagner', '63-(921)570-9495', 2);
insert into mechanic (id, delete_flag, email, first_name, last_name, phone_number, user_id) values (20, true, 'jbaileyj@weibo.com', 'Judith', 'Bailey', '1-(770)986-0164', 2);

/* user with id = 1 */
insert into maintenance_activity (id, activity_name, user_id) values (1, 'Oil Change', 1);
insert into maintenance_activity (id, activity_name, user_id) values (2, 'Tire Rotation', 1);
insert into maintenance_activity (id, activity_name, user_id) values (3, 'Check Engine Light', 1);
insert into maintenance_activity (id, activity_name, user_id) values (4, 'Check Tire Pressure', 1);
insert into maintenance_activity (id, activity_name, user_id) values (5, 'Engine Overheating', 1);
insert into maintenance_activity (id, activity_name, user_id) values (6, 'Filter Check', 1);
insert into maintenance_activity (id, activity_name, user_id) values (7, 'Brake Inspection', 1);
insert into maintenance_activity (id, activity_name, user_id) values (8, 'Windshield Wipers', 1);

/* user with id = 2 */
insert into maintenance_activity (id, activity_name, user_id) values (9, 'Oil Change', 2);
insert into maintenance_activity (id, activity_name, user_id) values (10, 'Tire Rotation', 2);
insert into maintenance_activity (id, activity_name, user_id) values (11, 'Check Engine Light', 2);
insert into maintenance_activity (id, activity_name, user_id) values (12, 'Check Tire Pressure', 2);
insert into maintenance_activity (id, activity_name, user_id) values (13, 'Engine Overheating', 2);
insert into maintenance_activity (id, activity_name, user_id) values (14, 'Filter Check', 2);
insert into maintenance_activity (id, activity_name, user_id) values (15, 'Brake Inspection', 2);
insert into maintenance_activity (id, activity_name, user_id) values (16, 'Windshield Wipers', 2);

/* user with id = 1 */
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (1, 'No issues', 0, '2015-10-01', 207093, '2015-05-19', 1, 1, 1, 1);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (2, 'No issues', 1, '2010-06-17', 5063, '2003-09-15', 2, 2, 1, 3);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (4, 'No issues', 0, '2005-12-02', 86078, '2007-02-27', 3, 3, 1, 5);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (5, 'No issues', 0, '2003-12-13', 135356, '2011-10-14', 4, 5, 1, 6);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (7, 'No issues', 1, '2010-08-02', 20523, '2012-02-09', 5, 6, 1, 10);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (8, 'No issues', 0, '2007-07-01', 118643, '2011-01-01', 6, 7, 1, 13);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (9, 'No issues', 1, '2001-02-28', 91584, '2016-03-31', 7, 8, 1, 15);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (12, 'No issues', 1, '2005-02-18', 175997, '2009-11-01', 8, 10, 1, 16);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (16, 'No issues', 1, '2007-11-15', 245343, '2003-09-03', 1, 11, 1, 17);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (20, 'No issues', 1, '2003-01-26', 234661, '2015-03-09', 2, 12, 1, 20);

/* user with id = 2 */
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (3, 'No issues', 0, '2014-11-23', 118474, '2002-09-05', 9, 4, 2, 2);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (6, 'No issues', 1, '2004-03-22', 38549, '2008-06-23', 10, 9, 2, 4);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (10, 'No issues', 1, '2014-07-02', 188816, '2014-05-07', 11, 13, 2, 7);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (11, 'No issues', 0, '2008-03-12', 34262, '2006-04-07', 12, 15, 2, 8);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (13, 'No issues', 0, '2009-12-28', 92177, '2001-07-23', 13, 20, 2, 9);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (14, 'No issues', 0, '2008-09-27', 207337, '2014-01-19', 14, 4, 2, 11);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (15, 'No issues', 0, '2006-02-09', 35962, '2012-12-15', 15, 9, 2, 12);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (17, 'No issues', 1, '2008-03-30', 125936, '2015-09-22', 16, 13, 2, 14);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (18, 'No issues', 0, '2014-04-29', 50280, '2002-08-09', 9, 15, 2, 18);
insert into maintenance_session (id, activity_note, completed, end_date, mileage, start_date, maintenanceactivity_id, mechanic_id, user_id, vehicle_id) values (19, 'No issues', 0, '2003-01-03', 105526, '2010-09-07', 10, 20, 2, 19);
