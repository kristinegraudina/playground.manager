package com.kgraudina.playground.manager.service;

import com.kgraudina.playground.manager.objects.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class PlaygroundManagementServiceImpl implements PlaygroundManagement {
    Scanner scanner = new Scanner(System.in);
    private List<Attraction> attractions = new ArrayList<Attraction>();
    private List<Visitor> playgroundVisitors = new ArrayList<Visitor>();
    int ticketNumber;
    int totalVisitorsThisSession;


    public void playgroundManagerInit() {
        while (true) {
            int option = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("1. Create playground.");
                    System.out.println("0. Exit.");
                    option = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Alert: Invalid input type!");
                    scanner.next();
                }
            }

            switch (option) {
                case 1:
                    attractions.clear();
                    playgroundVisitors.clear();
                    createEditPlayground(true);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Alert: Invalid option.");
            }
        }
    }

    private void createEditPlayground(boolean cameFromStartMenu) {
        while (true) {
            int option = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Add/remove attractions:");
                    System.out.println("1. Add Ball Pit.");
                    System.out.println("2. Add Carousel.");
                    System.out.println("3. Add Slide.");
                    System.out.println("4. Add Swing.");
                    System.out.println("5. Remove Attraction.");
                    System.out.println("6. Confirm.");
                    System.out.println("0. Back.");

                    option = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Alert: Invalid input type!");
                    scanner.next();
                }
            }

            switch (option) {
                case 1:
                    attractions.add(new BallPit());
                    break;
                case 2:
                    attractions.add(new Carousel());
                    break;
                case 3:
                    attractions.add(new Slide());
                    break;
                case 4:
                    attractions.add(new Swing());
                    break;
                case 5:
                    if (attractions.isEmpty()) {
                        System.out.println("Alert: Please add at least one attraction first!");
                    } else {
                        removeAttraction(attractions);
                    }
                    break;
                case 6:
                    if (attractions.isEmpty()) {
                        System.out.println("Alert: Please add at least one attraction first!");
                    } else managePlayground();
                    break;
                case 0:
                    if (cameFromStartMenu) {
                        attractions.clear();
                        playgroundVisitors.clear();
                        playgroundManagerInit();
                    } else return;
                default:
                    System.out.println("Alert: Invalid option.");
            }
        }
    }


    private void removeAttraction(List<Attraction> attractions) {
        while (true) {
            int option = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    int i = 1;
                    System.out.println("Choose which attraction to remove:");
                    for (Attraction attraction : attractions) {
                        System.out.println((i++) + ". " + attraction.getName());
                    }
                    System.out.println(0 + ". Back");
                    option = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Alert: Invalid input type!");
                    scanner.next();
                }
            }

            if (option == 0) {
                break;
            } else if (option <= attractions.size()) {
                attractions.remove(option - 1);
            } else {
                System.out.println("Alert: Invalid option.");
            }
        }
    }

    private void managePlayground() {
        while (true) {
            int option = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Manage attractions:");
                    System.out.println("1. Add visitor to playground.");
                    System.out.println("2. Remove visitor from playground.");
                    System.out.println("3. Add visitor to attraction.");
                    System.out.println("4. Remove visitor from attraction.");
                    System.out.println("5: Remove visitor from queue.");
                    System.out.println("6. Add/Remove attraction.");
                    System.out.println("7. Show playground utilization/statistics.");
                    System.out.println("0. Back.");

                    option = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Alert: Invalid input type!");
                    scanner.next();
                }
            }

            switch (option) {
                case 1:
                    addPlaygroundVisitors();
                    break;
                case 2:
                    removePlaygroundVisitors();
                    break;
                case 3:
                    addVisitorToAttraction();
                    break;
                case 4:
                    removeVisitorFromAttraction();
                    break;
                case 5:
                    removeVisitorFromQueue();
                    break;
                case 6:
                    createEditPlayground(false);
                    break;
                case 7:
                    showStatistics();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Alert: Invalid option.");

            }
        }
    }

    private void addPlaygroundVisitors() {
        System.out.println("Add visitor to playground:");
        System.out.println("Enter name __");
        String name = scanner.next();
        int age = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter age __");
                age = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Alert: Invalid input type!");
                scanner.next();
            }
        }
        ticketNumber = ticketNumber + 1;
        playgroundVisitors.add(new Visitor(name, age, ticketNumber));
        totalVisitorsThisSession++;
    }

    private void removePlaygroundVisitors() {
        while (true) {
            int option = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    int i = 1;
                    System.out.println("Choose which visitor to remove:");
                    for (Visitor visitor : playgroundVisitors) {
                        System.out.println((i++) + ". [ Name: " + visitor.getName() + " || Age: " + visitor.getAge() + " || Ticket Nr.:" + visitor.getTicketNumber() + " ]");
                    }
                    System.out.println(0 + ". Back");

                    option = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Alert: Invalid input type!");
                    scanner.next();
                }
            }

            if (option == 0) {
                break;
            } else if (option <= playgroundVisitors.size()) {
                playgroundVisitors.remove(option - 1);
            } else {
                System.out.println("Alert: Invalid option.");
            }
        }
    }

    private void addVisitorToAttraction() {
        while (true) {
            int i;
            int option = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    i = 1;
                    System.out.println("Select visitor:");
                    for (Visitor visitor : playgroundVisitors) {
                        System.out.println((i++) + ". [ Name: " + visitor.getName() + " || Age: " + visitor.getAge() + " || Ticket Nr.:" + visitor.getTicketNumber() + " ]");
                    }
                    System.out.println(0 + ". Back");

                    option = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Alert: Invalid input type!");
                    scanner.next();
                }
            }

            if (option == 0) {
                break;
            } else if (option <= playgroundVisitors.size()) {
                int option2 = 0;
                validInput = false;
                while (!validInput) {
                    try {
                        i = 1;
                        System.out.println("Select attraction to place visitor into:");
                        for (Attraction attraction : attractions) {
                            System.out.println((i++) + ". " + attraction.getName());
                        }
                        System.out.println(0 + ". Back");

                        option2 = scanner.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Alert: Invalid input type!");
                        scanner.next();
                    }
                }

                if (option2 == 0) {
                    break;
                } else if ((attractions.get(option2 - 1).getParticipants().size() + 1) <= attractions.get(option2 - 1).getTotalCapacity()) {
                    attractions.get(option2 - 1).getParticipants().add(playgroundVisitors.get(option - 1));
                    playgroundVisitors.remove(option - 1);
                } else {
                    int option3 = 0;
                    validInput = false;
                    while (!validInput) {
                        try {
                            System.out.println("Attraction full. Do you want to add visitor to queue?");
                            System.out.println("1. Yes.");
                            System.out.println("2. No.");

                            option3 = scanner.nextInt();
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Alert: Invalid input type!");
                            scanner.next();
                        }
                    }

                    switch (option3) {
                        case 1:
                            attractions.get(option2 - 1).getQueue().add(playgroundVisitors.get(option - 1));
                            playgroundVisitors.remove(option - 1);
                        case 2:
                            return;
                        default:
                            System.out.println("Alert: Invalid option.");
                    }
                }
                break;
            } else {
                System.out.println("Alert: Invalid option.");
            }
        }
    }

    private void removeVisitorFromAttraction() {
        while (true) {
            int i;
            int option = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    i = 1;
                    System.out.println("Choose which attraction to manage:");
                    for (Attraction attraction : attractions) {
                        System.out.println((i++) + ". " + attraction.getName());
                    }
                    System.out.println(0 + ". Back");

                    option = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Alert: Invalid input type!");
                    scanner.next();
                }
            }

            if (option == 0) {
                break;
            } else if (option <= attractions.size()) {
                while (true) {
                    int option2 = 0;
                    validInput = false;
                    while (!validInput) {
                        try {
                            i = 1;
                            System.out.println("Choose which visitor to remove:");
                            List<Visitor> participantsList = attractions.get(option - 1).getParticipants();
                            for (Visitor participant : participantsList) {
                                System.out.println((i++) + ". " + participant.getName());
                            }
                            System.out.println(0 + ". Back");

                            option2 = scanner.nextInt();
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Alert: Invalid input type!");
                            scanner.next();
                        }
                    }

                    if (option2 == 0) {
                        break;
                    } else {
                        if (attractions.get(option - 1).getQueue().isEmpty()) {
                            playgroundVisitors.add(attractions.get(option - 1).getParticipants().get(option2 - 1));
                            attractions.get(option - 1).getParticipants().remove(option2 - 1);

                        } else {
                            playgroundVisitors.add(attractions.get(option - 1).getParticipants().get(option2 - 1));
                            attractions.get(option - 1).getParticipants().remove(option2 - 1);
                            attractions.get(option - 1).getParticipants().add(attractions.get(option - 1).getQueue().get(0));
                            attractions.get(option - 1).getQueue().remove(0);
                        }
                    }
                }
            } else {
                System.out.println("Alert: Invalid option.");
            }
        }
    }

    private void removeVisitorFromQueue() {
        while (true) {
            int i = 1;
            System.out.println("Select attraction who's queue you want to manage:");
            for (Attraction attraction : attractions) {
                int option = 0;
                boolean validInput = false;
                while (!validInput) {
                    try {
                        if (!attraction.getQueue().isEmpty()) {
                            System.out.println((i++) + ". " + attraction.getName());
                        }
                        System.out.println(0 + ". Back");

                        option = scanner.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Alert: Invalid input type!");
                        scanner.next();
                    }
                }

                if (option == 0) {
                    return;
                } else {
                    i = 1;
                    while (true) {
                        List<Visitor> attractionQueue = null;
                        int option2 = 0;
                        validInput = false;
                        while (!validInput) {
                            try {
                                attractionQueue = attractions.get(option - 1).getQueue();
                                for (Visitor visitor : attractionQueue) {
                                    System.out.println((i++) + ". [ Name: " + visitor.getName() + " || Age: " + visitor.getAge() + " || Ticket Nr.:" + visitor.getTicketNumber() + " ]");
                                }
                                System.out.println(0 + ". Back");

                                option2 = scanner.nextInt();
                                validInput = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Alert: Invalid input type!");
                                scanner.next();
                            }
                        }

                        if (option2 == 0) {
                            break;
                        } else {
                            playgroundVisitors.add(attractionQueue.get(option2 - 1));
                            attractionQueue.remove(option2 - 1);
                        }
                    }
                }
            }
        }
    }

    private void showStatistics() {
        while (true) {
            int option = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Playground statistics:");
                    System.out.println("Total visitors today:" + totalVisitorsThisSession);

                    int i = 1;
                    for (Attraction attraction : attractions) {
                        System.out.println((i++) + ". " + attraction.getName() + "[ " + attraction.getUtilisation() + "% ]");
                    }

                    System.out.println(0 + ". Back");

                    option = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Alert: Invalid input type!");
                    scanner.next();
                }
            }

            if (option == 0) {
                return;
            } else {
                System.out.println("Alert: Invalid option.");
            }
        }
    }
}
